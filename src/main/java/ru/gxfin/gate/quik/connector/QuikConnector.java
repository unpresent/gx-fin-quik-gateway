package ru.gxfin.gate.quik.connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ru.gxfin.gate.quik.api.ConnectorState;
import ru.gxfin.gate.quik.api.QuikConnectionApi;
import ru.gxfin.gate.quik.api.QuikGetApi;
import ru.gxfin.gate.quik.commands.*;
import ru.gxfin.gate.quik.model.original.*;
import ru.gxfin.gate.quik.errors.QuikConnectorException;

import java.io.IOException;

/**
 * Реализация API взаимодействия с Quik.
 *
 * @author Vladimir Gagarkin
 * @since 1.0
 */
@Slf4j
public class QuikConnector implements QuikConnectionApi, QuikGetApi {
    private final QuikNamedPipeController pipeController;
    private final ObjectMapper objectMapper;

    /**
     * Объект форматирования команды на получение AllTradesPackage.
     * Делаем полем Connector-а для повторного использования (возможно, т.к. Reset делается внутри synchronized)
     */
    private final QuikNamedPipeCommandGetAllTradesPackage commandGetAllTradesPackage;

    /**
     * Объект форматирования команды на получение DealsPackage.
     * Делаем полем Connector-а для повторного использования (возможно, т.к. Reset делается внутри synchronized).
     */
    private final QuikNamedPipeCommandGetDealsPackage commandGetDealsPackage;

    /**
     * Объект форматирования команды на получение OrdersPackage.
     * Делаем полем Connector-а для повторного использования (возможно, т.к. Reset делается внутри synchronized).
     */
    private final QuikNamedPipeCommandGetOrdersPackage commandGetOrdersPackage;

    /**
     * Объект форматирования команды на получение SecuritiesPackage.
     * Делаем полем Connector-а для повторного использования (возможно, т.к. Reset делается внутри synchronized).
     */
    private final QuikNamedPipeCommandGetSecuritiesPackage commandGetSecuritiesPackage;

    /**
     * Объект форматирования команды на получение SessionState.
     * Делаем полем Connector-а для повторного использования (возможно, т.к. Reset делается внутри synchronized).
     */
    private final QuikNamedPipeCommandGetSessionState commandGetSessionState;

    public QuikConnector(ObjectMapper objectMapper, String pipeName, int inBufferSize) {
        this.commandGetAllTradesPackage = new QuikNamedPipeCommandGetAllTradesPackage();
        this.commandGetDealsPackage = new QuikNamedPipeCommandGetDealsPackage();
        this.commandGetOrdersPackage = new QuikNamedPipeCommandGetOrdersPackage();
        this.commandGetSecuritiesPackage = new QuikNamedPipeCommandGetSecuritiesPackage();
        this.commandGetSessionState = new QuikNamedPipeCommandGetSessionState();
        this.objectMapper = objectMapper;
        this.pipeController = new QuikNamedPipeController(pipeName, inBufferSize);
    }

    @Override
    public void init(String pipeName) {
        this.pipeController.init(pipeName);
        log.info("Finished init(pipeName = {})", pipeName);
    }

    @Override
    public boolean tryConnect() throws QuikConnectorException {
        boolean result = this.pipeController.tryConnect();
        log.info("Finished tryConnect(): result = {}", result);
        return result;
    }

    @Override
    public void disconnect() throws IOException {
        this.pipeController.disconnect();
        log.info("Finished disconnect()");
    }

    @Override
    public String getPipeName() {
        return this.pipeController.getPipeName();
    }

    @Override
    public String getCurrentPipeName() {
        return this.pipeController.getCurrentPipeName();
    }

    @Override
    public ConnectorState getState() {
        return this.pipeController.getState();
    }

    protected void checkIsActive(String action) throws QuikConnectorException {
        if (!this.isActive()) {
            log.info("Connector can't {} because it isn't active!", action);
            throw new QuikConnectorException("Connector can't " + action + " because it isn't active!");
        }
    }

    @SuppressWarnings("rawtypes")
    protected <P extends OriginalQuikStandardDataPackage> P getStandardPackage
            (QuikNamedPipeCommandStandardGet getCommand, long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        synchronized (this) {
            checkIsActive("get " + getCommand.getCommandName());

            // Возможно повторное использование getCommand, т.к. используется внутри synchronized всегда в одном потоке
            getCommand.Reset(fromRowIndex, packageSizeLimit);

            String commandMessage = getCommand.toMessage();
            this.pipeController.sendMessage(commandMessage);

            String receivedMessage = this.pipeController.receiveMessage();
            @SuppressWarnings("unchecked")
            Class<P> packageType = getCommand.resultClass();
            P result = this.objectMapper.readValue(receivedMessage, packageType);

            int lastLoadedRowIndex = result.size() > 0 ? result.getRow(result.size() - 1).getRowIndex() : -1;
            log.debug("{}: packageSize = {}; loadedIndex = {}", result.getClass().getSimpleName(), result.getQuikPackageSize(), lastLoadedRowIndex);
            if (result.getQuikPackageSize() != result.size()) {
                log.error("Неверный packageSize == {}; result.size() == {}", result.getQuikPackageSize(), result.size());
            }

            return result;
        }
    }

    @Override
    public OriginalQuikAllTradesPackage getAllTradesPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        return getStandardPackage(this.commandGetAllTradesPackage, fromRowIndex, packageSizeLimit);
    }

    @Override
    public OriginalQuikOrdersPackage getOrdersPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        return getStandardPackage(this.commandGetOrdersPackage, fromRowIndex, packageSizeLimit);
    }

    @Override
    public OriginalQuikDealsPackage getDealsPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        return getStandardPackage(this.commandGetDealsPackage, fromRowIndex, packageSizeLimit);
    }

    @Override
    public OriginalQuikSecuritiesPackage getSecuritiesPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        return getStandardPackage(this.commandGetSecuritiesPackage, fromRowIndex, packageSizeLimit);
    }

    @Override
    public OriginalQuikSessionState getSessionState() throws QuikConnectorException, IOException {
        synchronized (this) {
            checkIsActive("get " + commandGetSessionState.getCommandName());

            String commandMessage = commandGetSessionState.toMessage();
            this.pipeController.sendMessage(commandMessage);

            String receivedMessage = this.pipeController.receiveMessage();
            OriginalQuikSessionState result = this.objectMapper.readValue(receivedMessage, OriginalQuikSessionState.class);

            log.debug("{}.getSessionState(): sessionId = {}; isConnected = {}; ConnectionTime = {}", this.getClass().getSimpleName(), result.getSessionId(), result.isConnected(), result.getConnectionTime());

            return result;
        }
    }
}
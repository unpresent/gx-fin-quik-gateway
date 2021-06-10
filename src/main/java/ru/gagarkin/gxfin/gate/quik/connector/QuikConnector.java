package ru.gagarkin.gxfin.gate.quik.connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ru.gagarkin.gxfin.gate.quik.api.ConnectorState;
import ru.gagarkin.gxfin.gate.quik.api.QuikConnectionApi;
import ru.gagarkin.gxfin.gate.quik.api.QuikGetApi;
import ru.gagarkin.gxfin.gate.quik.commands.*;
import ru.gagarkin.gxfin.gate.quik.dto.*;
import ru.gagarkin.gxfin.gate.quik.errors.QuikConnectorException;

import java.io.IOException;

/**
 * Реализация API взаимодействия с Quik
 *
 * @author Vladimir Gagarkin
 * @since 1.0
 */
@Slf4j
public class QuikConnector implements QuikConnectionApi, QuikGetApi {
    private final QuikNamedPipeController pipeController;
    private final ObjectMapper objectMapper;

    /**
     * Объект форматирования команды на полуение AllTradesPackage.
     * Делаем полем Connector-а для повтороного использования (возможно, т.к. Reset делается внтури synchronized)
     */
    private final QuikNamedPipeCommandGetAllTradesPackage commandGetAllTradesPackage;

    /**
     * Объект форматирования команды на полуение DealsPackage.
     * Делаем полем Connector-а для повтороного использования (возможно, т.к. Reset делается внтури synchronized)
     */
    private final QuikNamedPipeCommandGetDealsPackage commandGetDealsPackage;

    /**
     * Объект форматирования команды на полуение OrdersPackage.
     * Делаем полем Connector-а для повтороного использования (возможно, т.к. Reset делается внтури synchronized)
     */
    private final QuikNamedPipeCommandGetOrdersPackage commandGetOrdersPackage;

    /**
     * Объект форматирования команды на полуение SecuritiesPackage.
     * Делаем полем Connector-а для повтороного использования (возможно, т.к. Reset делается внтури synchronized)
     */
    private final QuikNamedPipeCommandGetSecuritiesPackage commandGetSecuritiesPackage;

    /**
     * Объект форматирования команды на полуение SessionState.
     * Делаем полем Connector-а для повтороного использования (возможно, т.к. Reset делается внтури synchronized)
     */
    private final QuikNamedPipeCommandGetSessionState commandGetSessionState;

    public QuikConnector(String pipeName, int inBufferSize) {
        this.commandGetAllTradesPackage = new QuikNamedPipeCommandGetAllTradesPackage();
        this.commandGetDealsPackage = new QuikNamedPipeCommandGetDealsPackage();
        this.commandGetOrdersPackage = new QuikNamedPipeCommandGetOrdersPackage();
        this.commandGetSecuritiesPackage = new QuikNamedPipeCommandGetSecuritiesPackage();
        this.commandGetSessionState = new QuikNamedPipeCommandGetSessionState();

        this.objectMapper = new ObjectMapper();
        this.pipeController = new QuikNamedPipeController(pipeName, inBufferSize);
    }

    @Override
    public void init(String pipeName) {
        this.pipeController.init(pipeName);
        log.info("Finished init(pipeName = {})", pipeName);
    }

    @Override
    public boolean tryConnect() throws IOException, QuikConnectorException, InterruptedException {
        boolean result = this.pipeController.tryConnect();
        log.info("Finished tryConnect(): result = {}", result);
        return result;
    }

    /*
    @Override
    public boolean tryConnect(int attempts, int pauseMs) throws IOException, QuikConnectorException, InterruptedException {
        boolean result = this.pipeController.tryConnect(attempts, pauseMs);
        log.info("Finished tryConnect(attempts, pauseMs): result = {}", result);
        return result;
    }
    //*/

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

    protected <P extends StandardPackage> P getStandardPackage
            (QuikNamedPipeCommandStandardGet getCommand, long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        synchronized (this) {
            checkIsActive("get " + getCommand.getCommandName());

            // Возможно повторное использование getCommand, т.к. используется внтури synchronized всегда в одном потоке
            getCommand.Reset(fromRowIndex, packageSizeLimit);

            String commandMessage = getCommand.toMessage();
            this.pipeController.sendMessage(commandMessage);

            String receivedMessage = this.pipeController.receiveMessage();
            Class<P> packageType = getCommand.resultClass();
            P result = this.objectMapper.readValue(receivedMessage, packageType);

            int lastLoadedRowIndex = result.rows.length > 0 ? result.rows[result.rows.length - 1].rowIndex : -1;
            log.debug("{}: packageSize = {}; loadedIndex = {}", result.getClass().getSimpleName(), result.packageSize, lastLoadedRowIndex);

            return result;
        }
    }

    @Override
    public AllTradesPackage getAllTradesPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        AllTradesPackage result = getStandardPackage(this.commandGetAllTradesPackage, fromRowIndex, packageSizeLimit);
        return result;
    }

    @Override
    public OrdersPackage getOrdersPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        OrdersPackage result = getStandardPackage(this.commandGetOrdersPackage, fromRowIndex, packageSizeLimit);
        return result;
    }

    @Override
    public DealsPackage getDealsPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        DealsPackage result = getStandardPackage(this.commandGetDealsPackage, fromRowIndex, packageSizeLimit);
        return result;
    }

    @Override
    public SecuritiesPackage getSecuritiesPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException {
        SecuritiesPackage result = getStandardPackage(this.commandGetSecuritiesPackage, fromRowIndex, packageSizeLimit);
        return result;
    }

    @Override
    public SessionState getSessionState() throws QuikConnectorException, IOException {
        synchronized (this) {
            checkIsActive("get " + commandGetSessionState.getCommandName());

            String commandMessage = commandGetSessionState.toMessage();
            this.pipeController.sendMessage(commandMessage);

            String receivedMessage = this.pipeController.receiveMessage();
            SessionState result = this.objectMapper.readValue(receivedMessage, SessionState.class);

            log.debug("{}.getSessionState(): sessionId = {}; isConnected = {}; ConnectionTime = {}", this.getClass().getSimpleName(), result.sessionId, result.isConnected, result.connectionTime);

            return result;
        }
    }
}

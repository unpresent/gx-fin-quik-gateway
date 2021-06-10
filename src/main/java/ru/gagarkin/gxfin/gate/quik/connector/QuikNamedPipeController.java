package ru.gagarkin.gxfin.gate.quik.connector;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import ru.gagarkin.gxfin.gate.quik.api.ConnectorState;
import ru.gagarkin.gxfin.gate.quik.api.QuikConnectionApi;
import ru.gagarkin.gxfin.gate.quik.errors.QuikConnectorException;
import ru.gagarkin.gxfin.gate.quik.api.QuikNamedPipeMessenger;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.Channel;

/**
 * Реализация взаимодействия с Quik через NamedPipe:
 * 1) открытие, закрытие NamedPipe-а
 * 2) отправка и получение команд через NamedPipe
 *
 * @author Vladimir Gagarkin
 * @since 1.0
 */
@Slf4j
class QuikNamedPipeController implements QuikConnectionApi, QuikNamedPipeMessenger {
    private static final String THIS_NAME = QuikNamedPipeController.class.getSimpleName();

    private static final String PIPE_PREFIX = "\\\\.\\pipe\\";
    private static final int TRACE_FIRST_SYMBOLS = 512;

    /**
     * Режим доступа к NamedPipe. rw - Read + Write - двусторонний доступ
     */
    private static final String PIPE_ACCESS_MODE = "rw";

    private static final String ERROR_ANSWER_BEGINS = "ERROR";

    /**
     * Размер для буфера входящих сообщений.
     */
    private final int inBufferSize;

    /**
     * Определяет имя pipe-а, с которым установлено текущее соединение.
     * Если соединение не установленно, то null
     */
    public String getCurrentPipeName() {
        return currentPipeFile.getName();
    }

    /**
     * Буфер для входящего сообщения. Т.к. читаем и отправляем в один поток, достаточно всегда одного такого буфера
     */
    private final byte[] inBuffer;

    /**
     * Определяет имя pipe-а, с которым будет установлено следующиее соединение
     */
    @Getter
    private String pipeName;

    /**
     * Определяет файл-pipe-а, с которым будет установлено следующиее соединение
     */
    private File pipeFile;

    /**
     * Определяет файл-pipe-а, с которым установлено текущее соединение.
     * Если соединение не установленно, то null
     */
    private File currentPipeFile;

    /**
     * Сосотояние Connector-а
     */
    @Getter
    private ConnectorState state;

    /**
     * NamedPipe, через который происходит обмен данными с Quik-ом
     */
    private RandomAccessFile currentPipe;

    public QuikNamedPipeController(String pipeName, int inBufferSize) {
        log.debug("is creating; pipeName = {}, inBufferSize = {}", pipeName, inBufferSize);

        this.state = ConnectorState.Disconnected;
        this.inBufferSize = inBufferSize;
        this.inBuffer = new byte[this.inBufferSize];
        this.init(pipeName);
    }

    /**
     * Инициализирует параметры Connector-а.
     *
     * @param pipeName имя NamedPipe-а, которое будет испольоваться для связи с Quik
     */
    @Override
    public synchronized void init(String pipeName) {
        if (!StringUtils.isNotEmpty(pipeName)) {
            this.pipeName = null;
            this.pipeFile = null;
            log.debug("has reset pipeName to null");
        } else {
            this.pipeName = pipeName;
            log.debug("has initialized; pipeName = {}", this.pipeName);
        }
    }

    /**
     * Открытие NamedPipe-а.
     * После открытия NamedPipe-а переходим в состояние ожидания.
     *
     * @throws IOException
     * @throws QuikConnectorException
     */
    protected synchronized void connectInternal() throws IOException, QuikConnectorException, InterruptedException {
        this.state = ConnectorState.Connecting;
        try {
            this.currentPipe = null; // для случаев, если будут исключения
            Channel channel = null;

            log.info("is connecting to {}", this.pipeFile.getName());
            if (this.currentPipeFile == null || this.currentPipeFile != this.pipeFile) {
                this.currentPipeFile = this.pipeFile;
            }
            Thread.sleep(100);
            this.currentPipe = new RandomAccessFile(this.currentPipeFile, PIPE_ACCESS_MODE);
            log.info("opened RandomAccessFile success", this.currentPipeFile.getName());
            if (currentPipe != null) {
                Thread.sleep(100);
                channel = currentPipe.getChannel();
            }
            Thread.sleep(100);
            if (!channel.isOpen()) {
                log.info("connectInternal(): can not open channel");
                this.state = ConnectorState.Disconnected;
                this.currentPipe.close();
                this.currentPipe = null;
                return;
            }
            this.state = ConnectorState.WaitCommand;
            //
            log.debug("is waiting");
        } finally {
            if (this.currentPipe == null) {
                this.state = ConnectorState.Disconnected;
                log.info("connectInternal(): this.state = ConnectorState.Disconnected");
            }
        }
    }

    /**
     * Попытка открытие NamedPipe-а с проверкой на существование файла-pipe-а, если есть вызывается connectInternal().
     *
     * @return true = получилось установить соединение за отведенное количество попыток
     * @throws IOException
     * @throws QuikConnectorException
     * @throws InterruptedException
     */
    @Override
    public synchronized boolean tryConnect() throws IOException, QuikConnectorException, InterruptedException {
        if (this.isActive() || this.currentPipe != null) {
            log.info("can not connect. Already is active!");
            throw new QuikConnectorException(THIS_NAME + " already is active!");
        }
        if (!StringUtils.isNotEmpty(this.pipeName)) {
            log.info("can not connect because pipeName is empty");
            throw new QuikConnectorException(THIS_NAME + " can not connect because pipeName is empty!");
        }

        this.pipeFile = null;

        for (var i = 0; i < 100; i++) {
            var vPipeFile = new File(PIPE_PREFIX + this.pipeName + i);
            if (vPipeFile.exists()) {
                this.pipeFile = vPipeFile;
                try {
                    this.connectInternal();
                    break;
                } catch (Exception e) {
                    this.pipeFile = null;
                    log.info("{} can't connect to pipe {}; exception: {} {}", vPipeFile, e.getClass().getName(), e.getMessage());
                    break;
                }
            }
        }

        var result = this.isActive();
        log.debug("tryConnect(); pipeFileName = {}, result = {}", this.pipeName, result);
        return result;
    }

    /**
     * Попытка открытие NamedPipe-а в цикле.
     * При обнаружении файла-pipe-а вызывается connect().
     *
     * @param attempts количество попыток подключиться
     * @param pauseMs  пауза в миллисекундах между попытками
     * @return true = получилось установить соединение за отведенное количество попыток
     * @throws IOException
     * @throws QuikConnectorException
     * @throws InterruptedException
     */
    /*
    @Override
    public synchronized boolean tryConnect(int attempts, int pauseMs) throws IOException, QuikConnectorException, InterruptedException {
        if (attempts < 1) {
            log.info("tryConnect(attempts, pauseMs) illegal argument attempts = {}", attempts);
            throw new IllegalArgumentException(THIS_NAME + "illegal argument attempts = " + attempts);
        }
        if (pauseMs < 0) {
            log.info("tryConnect(attempts, pauseMs) illegal argument pauseMs = {}", pauseMs);
            throw new IllegalArgumentException(THIS_NAME + "illegal argument attempts = " + attempts);

        }

        log.info("tryConnect(attempts, pauseMs): attempts = {}, pauseMs = {}", attempts, pauseMs);

        boolean result = false;
        for (var i = 0; i < attempts; i++) {
            result = tryConnect();
            if (result) {
                break;
            } else {
                log.info("is sleeping, because tryConnect() returns false");
                Thread.sleep(pauseMs);
            }
        }

        log.debug("has finished tryConnect(attempts, pauseMs) to {}, result = {}", this.pipeName, result);
        return result;
    }
    //*/

    /**
     * Закрытие NamedPipe-а.
     *
     * @throws IOException
     * @throws QuikConnectorException
     */
    @Override
    public synchronized void disconnect() throws IOException {
        this.state = ConnectorState.Disconnected;
        try {
            log.info("is disconnecting; currentPipeFile == {}", this.getCurrentPipeName());

            if (this.currentPipe != null) {
                try {
                    this.currentPipe.close();
                    log.debug("closed NamedPipe success");
                } finally {
                    this.currentPipe = null;
                }
            }
        } finally {
            this.currentPipeFile = null;
        }
    }

    /**
     * Чтение сообщение из NamedPipe (т.е. получение сообщения от Quik-а)
     *
     * @return String
     * @throws QuikConnectorException
     * @throws IOException
     */
    @Override
    public synchronized String receiveMessage() throws QuikConnectorException, IOException {
        if (!isActive()) {
            log.info("can't receiveMessage() because it isn't active");
            throw new QuikConnectorException(QuikNamedPipeMessenger.class.getSimpleName() + " can't receiveMessage() because it isn't active!");
        }
        if (this.state != ConnectorState.WaitCommand) {
            log.info("can't receiveMessage() because this.state == {}", this.state);
            throw new QuikConnectorException(QuikNamedPipeMessenger.class.getSimpleName() + " can't receiveMessage because it is " + this.state.toString() + "!");
        }

        this.state = ConnectorState.Receiving;

        log.debug("is receiving");
        String message;

        int countLoaded = this.currentPipe.read(this.inBuffer);
        if (countLoaded > 0) {
            message = new String(inBuffer, 0, countLoaded);
            var len = message.length();
            log.debug("has read {} bytes", countLoaded);
            log.trace("{}", len < TRACE_FIRST_SYMBOLS ? message : message.substring(0, TRACE_FIRST_SYMBOLS - 1) + "...");

            if (message.startsWith(ERROR_ANSWER_BEGINS)) {
                log.warn("Quik has sent: {}", message);
                this.state = ConnectorState.WaitCommand;
                throw new QuikConnectorException("Quik has sent: " + message);
            }
        } else {
            log.debug("has read {} bytes (Empty!)", countLoaded);
            message = "";
        }

        log.debug("is waiting");
        this.state = ConnectorState.WaitCommand;
        return message;
    }

    /**
     * Запись сообщения в NamedPipe (т.е. отправка сообщения в Quik)
     *
     * @param message
     * @throws QuikConnectorException
     * @throws IOException
     */
    @Override
    public synchronized void sendMessage(String message) throws QuikConnectorException, IOException {
        if (!isActive()) {
            log.info("can't sendMessage() because it isn't active");
            throw new QuikConnectorException(THIS_NAME + " can't sendMessage() because it isn't active!");
        }
        if (this.state != ConnectorState.WaitCommand) {
            log.info("can't sendMessage() because this.state == {}", this.state);
            throw new QuikConnectorException(THIS_NAME + " can't sendMessage() because it is " + this.state.toString() + "!");
        }

        this.state = ConnectorState.Sending;
        try {
            var len = message.length();
            log.trace("writing message: (len == {}) {}", len, len < TRACE_FIRST_SYMBOLS ? message : message.substring(0, TRACE_FIRST_SYMBOLS - 1) + "...");
            this.currentPipe.write(message.getBytes());
            log.debug("written message", message.length());
        } finally {
            log.debug("is waiting");
            this.state = ConnectorState.WaitCommand;
        }
    }
}

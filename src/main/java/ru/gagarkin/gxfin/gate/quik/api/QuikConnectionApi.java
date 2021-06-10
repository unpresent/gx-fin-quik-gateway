package ru.gagarkin.gxfin.gate.quik.api;

import ru.gagarkin.gxfin.gate.quik.errors.QuikConnectorException;

import java.io.IOException;

/**
 * Определяет интерфейс управления соединением с Quik через NamedPipe
 * @author Vladimir Gagarkin
 * @since 1.0
 */
public interface QuikConnectionApi {
    /**
     * Инициализирует параметры Connector-а.
     * @param pipeName имя NamedPipe-а, которое будет испольоваться для связи с Quik
     */
    void init(String pipeName);

    /**
     * Попытка открытие NamedPipe-а с предварительной проверкой налчия файла-pipe-а.
     * При отсуствии такого файла, не пытаемся установить соединение.
     * @return Успешно ли установили соединение
     * @throws IOException
     * @throws QuikConnectorException
     */
    boolean tryConnect() throws IOException, QuikConnectorException, InterruptedException;

    /**
     * Закрытие NamedPipe-а.
     * @throws IOException
     * @throws QuikConnectorException
     */
    void disconnect() throws IOException;

    /**
     * Закрытие и повторное открытие соединения
     * @return Успешно ли установили соединение
     * @throws IOException
     * @throws QuikConnectorException
     */
    default boolean reconnect() throws IOException, QuikConnectorException, InterruptedException {
        disconnect();
        return tryConnect();
    }

    /**
     * Получение текущего состояния Connector-а
     * @return
     */
    ConnectorState getState();

    /**
     * Определяет имя pipe-а, с которым будет установлено следующиее соединение
     */
    String getPipeName();

    /**
     * Определяет имя pipe-а, с которым установлено текущее соединение.
     * Если соединение не установленно, то null
     */
    String getCurrentPipeName();

    /**
     * Показывает аквтивен ли Connector
     * @return true, если сосотояние одно из: Connecting, WaitCommand, Receiving, Sending. false, если состояние Disconnected
     */
    default boolean isActive() {
        return (this.getState() != ConnectorState.Disconnected);
    }
}

package ru.gx.fin.gate.quik.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.fin.gate.quik.errors.QuikConnectorException;

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
    void init(@Nullable final String pipeName);

    /**
     * Попытка открытие NamedPipe-а с предварительной проверкой налчия файла-pipe-а.
     * При отсутствии такого файла, не пытаемся установить соединение.
     * @return Успешно ли установили соединение
     * @throws IOException Ошибки ввода/вывода
     * @throws QuikConnectorException Ошибка состояния соединения с Quik.
     * @throws InterruptedException Исключение принудительного останова.
     */
    boolean tryConnect() throws IOException, QuikConnectorException, InterruptedException;

    /**
     * Закрытие NamedPipe-а.
     * @throws IOException Ошибки ввода/вывода
     */
    void disconnect() throws IOException;

    /**
     * Закрытие и повторное открытие соединения
     * @return Успешно ли установили соединение
     * @throws IOException Ошибки ввода/вывода
     * @throws QuikConnectorException Ошибка состояния соединения с Quik.
     * @throws InterruptedException Исключение принудительного останова.
     */
    @SuppressWarnings("unused")
    default boolean reconnect() throws IOException, QuikConnectorException, InterruptedException {
        disconnect();
        return tryConnect();
    }

    /**
     * @return Получение текущего состояния Connector-а
     */
    @NotNull
    ConnectorState getState();

    /**
     * Определяет имя pipe-а, с которым будет установлено следующиее соединение
     */
    @Nullable
    String getPipeName();

    /**
     * Определяет имя pipe-а, с которым установлено текущее соединение.
     * Если соединение не установленно, то null
     */
    @Nullable
    String getCurrentPipeName();

    /**
     * Показывает аквтивен ли Connector
     * @return true, если сосотояние одно из: Connecting, WaitCommand, Receiving, Sending. false, если состояние Disconnected
     */
    default boolean isActive() {
        return (this.getState() != ConnectorState.Disconnected);
    }
}

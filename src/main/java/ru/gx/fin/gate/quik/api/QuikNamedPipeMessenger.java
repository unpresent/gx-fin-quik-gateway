package ru.gx.fin.gate.quik.api;

import ru.gx.fin.gate.quik.errors.QuikConnectorException;

import java.io.IOException;

/**
 * Определяет интерфейс обмена данными с Quik через NamedPipe
 * @author Vladimir Gagarkin
 * @since 1.0
 */
public interface QuikNamedPipeMessenger {
    /**
     * Чтение сообщение из NamedPipe (т.е. получение сообщения от Quik-а).
     * @return Строка - тело сообщения.
     * @throws QuikConnectorException Ошибка соединения с Quik.
     * @throws IOException Ошибка чтения из NamedPipe-файла.
     */
    String receiveMessage() throws QuikConnectorException, IOException;

    /**
     * Запись сообщения в NamedPipe (т.е. отправка сообщения в Quik).
     * @param message Строка - тело сообщения.
     * @throws QuikConnectorException Ошибка соединения с Quik.
     * @throws IOException Ошибка записи в NamedPipe-файл.
     */
    void sendMessage(String message) throws QuikConnectorException, IOException;
}

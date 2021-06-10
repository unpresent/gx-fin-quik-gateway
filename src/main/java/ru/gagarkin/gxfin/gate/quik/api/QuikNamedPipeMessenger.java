package ru.gagarkin.gxfin.gate.quik.api;

import ru.gagarkin.gxfin.gate.quik.errors.QuikConnectorException;

import java.io.IOException;

/**
 * Определяет интерфейс обмена данными с Quik через NamedPipe
 * @author Vladimir Gagarkin
 * @since 1.0
 */
public interface QuikNamedPipeMessenger {
    /**
     * Чтение сообщение из NamedPipe (т.е. получение сообщения от Quik-а)
     * @return String
     * @throws QuikConnectorException
     * @throws IOException
     */
    String receiveMessage() throws QuikConnectorException, IOException;

    /**
     * Запись сообщения в NamedPipe (т.е. отправка сообщения в Quik)
     * @param message
     * @throws QuikConnectorException
     * @throws IOException
     */
    void sendMessage(String message) throws QuikConnectorException, IOException;
}

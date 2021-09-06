package ru.gxfin.gate.quik.api;

/**
 * Варианты статусов Connector-а
 * @since 1.0
 */
public enum ConnectorState {
    /**
     * Соединение с Quik не установлено
     */
    Disconnected,

    /**
     * В процессе установки соединения (открытие NamedPipe-а)
     */
    Connecting,

    /**
     * Ожидаем получения команд: receive или send
     */
    WaitCommand,

    /**
     * В процессе чтения сообщения из NamedPipe.
     */
    Receiving,

    /**
     * В процессе записи сообщения в NamedPipe
     */
    Sending
}

package ru.gxfin.gate.quik.commands;

/**
 * Типы команд, отправляемых в Quik
 */
@SuppressWarnings("unused")
public enum QuikNamedPipeCommandType {
    /**
     * Команда на получение данных из Quik-а
     */
    Get,

    /**
     * Команда на отправку данных в Quik
     */
    Set
}

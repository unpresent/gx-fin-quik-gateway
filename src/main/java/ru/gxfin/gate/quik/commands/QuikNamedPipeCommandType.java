package ru.gxfin.gate.quik.commands;

/**
 * Типы команд, отправляемых в Quik
 */
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

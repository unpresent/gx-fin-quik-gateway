package ru.gxfin.gate.quik.commands;

import ru.gxfin.gate.quik.data.income.QuikAllTradesPackage;

/**
 * Команда на получение пакета Обезличенных Сделок, начиная с индекса fromIndex с ограничением размера пакета packetSizeLimit
 */
public class QuikNamedPipeCommandGetAllTradesPackage extends QuikNamedPipeCommandStandardGet {
    public static final String COMMAND_NAME = "AllTradesPackage";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public Class resultClass() {
        return QuikAllTradesPackage.class;
    }
}

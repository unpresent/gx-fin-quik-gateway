package ru.gagarkin.gxfin.gate.quik.commands;

import ru.gagarkin.gxfin.gate.quik.data.income.QuikSecuritiesPackage;

/**
 * Команда на получение пакета ФИ, начиная с индекса fromIndex с ограничением размера пакета packetSizeLimit
 */
public class QuikNamedPipeCommandGetSecuritiesPackage extends QuikNamedPipeCommandStandardGet {
    public static final String COMMAND_NAME = "SecuritiesPackage";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public Class resultClass() {
        return QuikSecuritiesPackage.class;
    }
}
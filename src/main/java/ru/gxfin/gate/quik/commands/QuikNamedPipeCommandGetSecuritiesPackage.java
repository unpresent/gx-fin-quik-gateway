package ru.gxfin.gate.quik.commands;

import ru.gxfin.gate.quik.model.original.OriginalQuikSecuritiesPackage;

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
    public Class<?> resultClass() {
        return OriginalQuikSecuritiesPackage.class;
    }
}
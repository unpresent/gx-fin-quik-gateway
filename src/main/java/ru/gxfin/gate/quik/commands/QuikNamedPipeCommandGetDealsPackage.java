package ru.gxfin.gate.quik.commands;

import ru.gxfin.gate.quik.model.original.OriginalQuikDealsPackage;

/**
 * Команда на получение пакета Сделок, начиная с индекса fromIndex с ограничением размера пакета packetSizeLimit
 */
public class QuikNamedPipeCommandGetDealsPackage extends QuikNamedPipeCommandStandardGet {
    public static final String COMMAND_NAME = "DealsPackage";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public Class<?> resultClass() {
        return OriginalQuikDealsPackage.class;
    }
}
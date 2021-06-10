package ru.gagarkin.gxfin.gate.quik.commands;

import ru.gagarkin.gxfin.gate.quik.dto.DealsPackage;

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
    public Class resultClass() {
        return DealsPackage.class;
    }
}
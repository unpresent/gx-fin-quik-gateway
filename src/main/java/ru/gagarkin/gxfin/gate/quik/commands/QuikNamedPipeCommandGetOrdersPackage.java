package ru.gagarkin.gxfin.gate.quik.commands;

import ru.gagarkin.gxfin.gate.quik.data.income.QuikOrdersPackage;

/**
 * Команда на получение пакета Заявок, начиная с индекса fromIndex с ограничением размера пакета packetSizeLimit
 */
public class QuikNamedPipeCommandGetOrdersPackage extends QuikNamedPipeCommandStandardGet {
    public static final String COMMAND_NAME = "OrdersPackage";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }


    @Override
    public Class resultClass() {
        return QuikOrdersPackage.class;
    }
}
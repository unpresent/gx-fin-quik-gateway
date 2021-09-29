package ru.gx.fin.gate.quik.commands;

import org.jetbrains.annotations.NotNull;
import ru.gx.fin.gate.quik.model.original.OriginalQuikOrdersPackage;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataPackage;

/**
 * Команда на получение пакета Заявок, начиная с индекса fromIndex с ограничением размера пакета packetSizeLimit
 */
public class QuikNamedPipeCommandGetOrdersPackage extends QuikNamedPipeCommandStandardGet {
    public static final String COMMAND_NAME = "OrdersPackage";

    @Override
    @NotNull
    public String getCommandName() {
        return COMMAND_NAME;
    }


    @Override
    @NotNull
    public Class<? extends OriginalQuikStandardDataPackage<? extends OriginalQuikStandardDataObject>> resultClass() {
        return OriginalQuikOrdersPackage.class;
    }
}
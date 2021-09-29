package ru.gx.fin.gate.quik.commands;

import org.jetbrains.annotations.NotNull;
import ru.gx.fin.gate.quik.model.original.OriginalQuikSecuritiesPackage;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataPackage;

/**
 * Команда на получение пакета ФИ, начиная с индекса fromIndex с ограничением размера пакета packetSizeLimit
 */
public class QuikNamedPipeCommandGetSecuritiesPackage extends QuikNamedPipeCommandStandardGet {
    public static final String COMMAND_NAME = "SecuritiesPackage";

    @Override
    @NotNull
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    @NotNull
    public Class<? extends OriginalQuikStandardDataPackage<? extends OriginalQuikStandardDataObject>> resultClass() {
        return OriginalQuikSecuritiesPackage.class;
    }
}
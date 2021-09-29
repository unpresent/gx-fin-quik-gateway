package ru.gx.fin.gate.quik.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataPackage;

public abstract class QuikNamedPipeCommandStandardGet extends AbstractQuikNamedPipeCommand {
    // public static final String PARAM_NAME_FROM_INDEX = "FromIndex";
    private long fromIndex;

    // public static final String PARAM_NAME_PACKET_SIZE_LIMIT = "PackageSizeLimit";
    private int packetSizeLimit;

    @SuppressWarnings("UnusedReturnValue")
    public QuikNamedPipeCommandStandardGet Reset(long fromIndex, int packetSizeLimit) {
        this.fromIndex = fromIndex;
        this.packetSizeLimit = packetSizeLimit;
        return this;
    }

    @Override
    @NotNull
    public QuikNamedPipeCommandType getCommandType() {
        return QuikNamedPipeCommandType.Get;
    }

    @Override
    @Nullable
    public String getCommandParams() {
        return fromIndex + ":" + packetSizeLimit;
    }

    @NotNull
    public abstract Class<? extends OriginalQuikStandardDataPackage<? extends OriginalQuikStandardDataObject>> resultClass();
}

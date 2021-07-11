package ru.gxfin.gate.quik.commands;

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
    public QuikNamedPipeCommandType getCommandType() {
        return QuikNamedPipeCommandType.Get;
    }

    @Override
    public String getCommandParams() {
        return fromIndex + ":" + packetSizeLimit;
    }

    @SuppressWarnings("rawtypes")
    public abstract Class resultClass();
}

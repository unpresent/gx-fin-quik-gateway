package ru.gx.fin.gate.quik.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class QuikNamedPipeCommandGetSessionState extends AbstractQuikNamedPipeCommand {
    public static final String COMMAND_NAME = "SessionState";

    @Override
    @NotNull
    public QuikNamedPipeCommandType getCommandType() {
        return QuikNamedPipeCommandType.Get;
    }

    @Override
    @NotNull
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    @Nullable
    public String getCommandParams() {
        return null;
    }
}

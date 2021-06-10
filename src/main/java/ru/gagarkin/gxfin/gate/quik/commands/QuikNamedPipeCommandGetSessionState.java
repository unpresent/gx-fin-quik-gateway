package ru.gagarkin.gxfin.gate.quik.commands;

public class QuikNamedPipeCommandGetSessionState extends AbstractQuikNamedPipeCommand {
    public static final String COMMAND_NAME = "SessionState";

    @Override
    public QuikNamedPipeCommandType getCommandType() {
        return QuikNamedPipeCommandType.Get;
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String getCommandParams() {
        return null;
    }
}

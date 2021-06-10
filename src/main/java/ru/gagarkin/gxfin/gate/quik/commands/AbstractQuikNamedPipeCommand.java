package ru.gagarkin.gxfin.gate.quik.commands;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public abstract class AbstractQuikNamedPipeCommand {
    @Override
    public String toString() {
        return this.toMessage();
    }

    public String toMessage() {
        String params = this.getCommandParams();
        return  this.getCommandType().toString()
                + ":" + this.getCommandName()
                + (StringUtils.isNotEmpty(params) ? ":" + params : "");
    }

    public abstract QuikNamedPipeCommandType getCommandType();

    public abstract String getCommandName();

    public abstract String getCommandParams();
}

package ru.gx.fin.gate.quik.commands;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public abstract class AbstractQuikNamedPipeCommand {
    @Override
    @NotNull
    public String toString() {
        return this.toMessage();
    }

    @NotNull
    public String toMessage() {
        String params = this.getCommandParams();
        return  this.getCommandType()
                + ":" + this.getCommandName()
                + (StringUtils.isNotEmpty(params) ? ":" + params : "");
    }

    @NotNull
    public abstract QuikNamedPipeCommandType getCommandType();

    @NotNull
    public abstract String getCommandName();

    @Nullable
    public abstract String getCommandParams();
}

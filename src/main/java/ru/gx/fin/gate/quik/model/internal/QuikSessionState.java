package ru.gx.fin.gate.quik.model.internal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import ru.gx.fin.gate.quik.model.original.OriginalQuikSessionState;
import ru.gx.data.AbstractDataObject;

import java.sql.Time;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class QuikSessionState extends AbstractDataObject {
    /**
     * Открыто ли соединение Quik с сервером
     */
    private boolean isConnected;

    /**
     * Текущая сессия
     */
    private String sessionId;

    /**
     * Текущее время на сервере
     */
    private Time serverTime;

    /**
     * Время открытия соединения с Сервером
     */
    private Time connectionTime;

    /**
     * Версия Quik-а
     */
    private String version;

    /**
     * Connection ?
     */
    private String connection;

    /**
     * ip_address ?
     */
    private String ipAddress;

    /**
     * ip_port ?
     */
    private String ipPort;

    /**
     * ip_comment ?
     */
    private String ipComment;

    @SuppressWarnings("unused")
    public QuikSessionState(@NotNull final OriginalQuikSessionState sourceDataObject) {
        super();
        this.isConnected = sourceDataObject.isConnected();
        this.sessionId = sourceDataObject.getSessionId();
        this.serverTime = sourceDataObject.getServerTime();
        this.connectionTime = sourceDataObject.getConnectionTime();
        this.version = sourceDataObject.getVersion();
        this.connection = sourceDataObject.getConnection();
        this.ipAddress = sourceDataObject.getIpAddress();
        this.ipPort = sourceDataObject.getIpPort();
        this.ipComment = sourceDataObject.getIpComment();
    }
}

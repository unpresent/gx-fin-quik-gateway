package ru.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.gxfin.common.data.AbstractDataObject;
import ru.gxfin.gate.quik.data.income.QuikSessionState;

import java.sql.Time;

@Getter
@Setter
@EqualsAndHashCode
public class SessionState extends AbstractDataObject {
    /**
     * Открыто ли соединение Quik с сервером
     */
    @JsonProperty
    private boolean isConnected;

    /**
     * Текущая сессия
     */
    @JsonProperty
    private String sessionId;

    /**
     * Текущее время на сервере
     */
    @JsonProperty
    private Time serverTime;

    /**
     * Время открытия соединения с Сервером
     */
    @JsonProperty
    private Time connectionTime;

    /**
     * Версия Quik-а
     */
    @JsonProperty
    private String version;

    /**
     * Connection ?
     */
    @JsonProperty
    private String connection;

    /**
     * ip_address ?
     */
    @JsonProperty
    private String ipAddress;

    /**
     * ip_port ?
     */
    @JsonProperty
    private String ipPort;

    /**
     * ip_comment ?
     */
    @JsonProperty
    private String ipComment;

    public SessionState() {
        super();
    }

    public SessionState(QuikSessionState sourceDataObject) {
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

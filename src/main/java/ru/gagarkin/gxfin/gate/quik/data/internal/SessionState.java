package ru.gagarkin.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.common.data.AbstractDataObject;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikSessionState;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataObject;

import java.sql.Time;

public class SessionState extends AbstractDataObject {
    /**
     * Открыто ли соединение Quik с сервером
     */
    @JsonProperty
    public boolean isConnected;

    /**
     * Текущая сессия
     */
    @JsonProperty
    public String sessionId;

    /**
     * Текущее время на сервере
     */
    @JsonProperty
    public Time serverTime;

    /**
     * Время открытия соединения с Сервером
     */
    @JsonProperty
    public Time connectionTime;

    /**
     * Версия Quik-а
     */
    @JsonProperty
    public String version;

    /**
     * Connection ?
     */
    @JsonProperty
    public String connection;

    /**
     * ip_address ?
     */
    @JsonProperty
    public String IpAddress;

    /**
     * ip_port ?
     */
    @JsonProperty
    public String ipPort;

    /**
     * ip_comment ?
     */
    @JsonProperty
    public String ipComment;

    public SessionState() {
        super();
    }

    public SessionState(QuikSessionState sourceDataObject) {
        super();
        this.isConnected = sourceDataObject.isConnected;
        this.sessionId = sourceDataObject.sessionId;
        this.serverTime = sourceDataObject.serverTime;
        this.connectionTime = sourceDataObject.connectionTime;
        this.version = sourceDataObject.version;
        this.connection = sourceDataObject.connection;
        this.IpAddress = sourceDataObject.IpAddress;
        this.ipPort = sourceDataObject.ipPort;
        this.ipComment = sourceDataObject.ipComment;
    }
}

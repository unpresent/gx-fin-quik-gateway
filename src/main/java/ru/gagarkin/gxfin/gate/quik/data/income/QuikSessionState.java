package ru.gagarkin.gxfin.gate.quik.data.income;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.common.data.AbstractDataObject;

import java.sql.Time;

public class QuikSessionState extends AbstractDataObject {
    /**
     * Открыто ли соединение Quik с сервером
     */
    @JsonProperty(value = "is_connected")
    public boolean isConnected;

    /**
     * Текущая сессия
     */
    @JsonProperty(value = "session_id")
    public String sessionId;

    /**
     * Текущее время на сервере
     */
    @JsonProperty(value = "server_time")
    public Time serverTime;

    /**
     * Время открытия соединения с Сервером
     */
    @JsonProperty(value = "connection_time")
    public Time connectionTime;

    /**
     * Версия Quik-а
     */
    @JsonProperty(value = "version")
    public String version;

    /**
     * Connection ?
     */
    @JsonProperty(value = "connection")
    public String connection;

    /**
     * ip_address ?
     */
    @JsonProperty(value = "ip_address")
    public String IpAddress;

    /**
     * ip_port ?
     */
    @JsonProperty(value = "ip_port")
    public String ipPort;

    /**
     * ip_comment ?
     */
    @JsonProperty(value = "ip_comment")
    public String ipComment;
}

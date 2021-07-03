package ru.gxfin.gate.quik.model.income;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.gxfin.common.data.AbstractDataObject;

import java.sql.Time;

@Getter
@Setter
@EqualsAndHashCode
public class QuikSessionState extends AbstractDataObject {
    /**
     * Открыто ли соединение Quik с сервером
     */
    @JsonProperty(value = "is_connected")
    private boolean isConnected;

    /**
     * Текущая сессия
     */
    @JsonProperty(value = "session_id")
    private String sessionId;

    /**
     * Текущее время на сервере
     */
    @JsonProperty(value = "server_time")
    private Time serverTime;

    /**
     * Время открытия соединения с Сервером
     */
    @JsonProperty(value = "connection_time")
    private Time connectionTime;

    /**
     * Версия Quik-а
     */
    @JsonProperty(value = "version")
    private String version;

    /**
     * Connection ?
     */
    @JsonProperty(value = "connection")
    private String connection;

    /**
     * ip_address ?
     */
    @JsonProperty(value = "ip_address")
    private String ipAddress;

    /**
     * ip_port ?
     */
    @JsonProperty(value = "ip_port")
    private String ipPort;

    /**
     * ip_comment ?
     */
    @JsonProperty(value = "ip_comment")
    private String ipComment;
}

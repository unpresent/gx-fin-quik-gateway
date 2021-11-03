package ru.gx.fin.gate.quik.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "quik")
@Getter
@Setter
public class ConfigurationPropertiesQuik {
    private Connector connector;
    private String pipeName = "C-QUIK_VTB-";
    private int bufferSize = 32768;
    private int attemptsOnConnect = 20;
    private int pauseOnConnectMs = 3000;
    private int intervalMandatoryReadStateMs = 5000;

    @Getter
    @Setter
    public static class Connector {
        private boolean enabled = true;
    }
}

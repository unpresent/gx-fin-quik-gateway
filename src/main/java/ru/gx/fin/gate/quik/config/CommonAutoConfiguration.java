package ru.gx.fin.gate.quik.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gx.fin.gate.quik.connector.QuikConnector;

@Configuration
@EnableConfigurationProperties(ConfigurationPropertiesQuik.class)
public class CommonAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "quik.connector.enabled", havingValue = "true")
    @Autowired
    public QuikConnector quikConnector(
            ObjectMapper objectMapper,
            @Value("${quik.pipe-name}") final String pipeName,
            @Value("${quik.buffer-size}") final int bufferSize
    ) {
        return new QuikConnector(objectMapper, pipeName, bufferSize);
    }

}

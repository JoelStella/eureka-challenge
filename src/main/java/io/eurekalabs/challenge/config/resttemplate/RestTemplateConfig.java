package io.eurekalabs.challenge.config.resttemplate;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private final RestTemplatePropertiesConfig restTemplatePropertiesConfig;

    public RestTemplateConfig(
            RestTemplatePropertiesConfig restTemplatePropertiesConfig) {
        this.restTemplatePropertiesConfig = restTemplatePropertiesConfig;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(restTemplatePropertiesConfig.getConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(restTemplatePropertiesConfig.getReadTimeout())).build();
    }

}

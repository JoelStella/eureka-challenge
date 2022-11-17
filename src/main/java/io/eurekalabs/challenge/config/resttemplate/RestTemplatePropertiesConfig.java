package io.eurekalabs.challenge.config.resttemplate;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "rest-template")
@Validated
@Data
public class RestTemplatePropertiesConfig {

    @NotNull
    private Long connectTimeout;

    @NotNull
    private Long readTimeout;

}

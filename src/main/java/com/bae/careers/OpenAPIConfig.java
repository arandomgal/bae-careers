package com.bae.careers;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.version}")
    private String appVersion;

    @Value("${spring.application.description}")
    private String appDescription;

    @Bean
    public OpenAPI myOpenAPI() {

        Info info = new Info().title(appName).version(appVersion).description(appDescription);
        return new OpenAPI().info(info);
    }
}

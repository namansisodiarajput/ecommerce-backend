package com.ecommerce.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for all(/some) of your Swagger needs. Your generated documentation will live at
 * https://cass-svc.rest.wip.internal.tide.co/swagger-ui/index.html or http://localhost:8080/swagger-ui/index.html when
 * running locally.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CASS-SVC")
                        .description("The cass-svc is responsible for doing exciting things!")
                        .version("1.0"));
    }
}
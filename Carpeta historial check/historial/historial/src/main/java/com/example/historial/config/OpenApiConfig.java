package com.example.historial.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

public class OpenApiConfig {

     @Bean
    public OpenAPI ubicacionAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Microservicio de Historial")
                .version("1.0")
                .description("Documentación del historial disponible"));
    }

}

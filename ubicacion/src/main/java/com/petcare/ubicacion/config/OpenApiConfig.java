package com.petcare.ubicacion.config;


import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI ubicacionAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Microservicio de Ubicacion")
                .version("1.0")
                .description("Documentación de Región, Comuna y Dirección"));
    }

}

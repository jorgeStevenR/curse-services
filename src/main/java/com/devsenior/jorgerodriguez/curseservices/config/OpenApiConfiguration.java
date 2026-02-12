package com.devsenior.jorgerodriguez.curseservices.config;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {

    @Bean
    OpenAPI openAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("API de gestion de cursos academicos.")
                .description("Sistema completo de gestion de cursos para una universidad virutal.")
                .version("v1.0")
                .contact(new Contact()
                    .name("Jorge Rodriguez")
                    .email("rodrigesj500@gmail.com")
                    .url("http://devseniorcod.com")
                )
                .license(new License()
                    .name("MIT Licence")
                    .url("https://opensource.org/licence/MIT")))
            .servers(List.of(
                new Server().url("http://localhost:8080").description("Entorno de desarrollo"),
                new Server().url("http://api.cursos.devsenior.com").description("Entorno de produccion")
            ));
    }
}

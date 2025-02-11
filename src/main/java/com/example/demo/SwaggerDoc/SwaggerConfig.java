package com.example.demo.SwaggerDoc;

import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(" Registration API")
                        .description("API documentation for the UserLogin and AdminLogins Registration application")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Kanifnath")
                                .email("kanifnath@example.com")
                                .url("https://google.com")));
                        
    }
}

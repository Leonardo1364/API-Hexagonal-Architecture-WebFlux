package com.hexagonal.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class IntegrationConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://moviesdb5.p.rapidapi.com/om")
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .defaultHeader("X-RapidAPI-Key", "b4552aa351msh6c5ccce14da6eb3p1e87edjsndd61858a2892")
                .defaultHeader("X-RapidAPI-Host", "moviesdb5.p.rapidapi.com")
                .build();
    }
}

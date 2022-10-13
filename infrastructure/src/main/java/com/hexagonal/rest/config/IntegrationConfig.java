package com.hexagonal.rest.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AllArgsConstructor
public class IntegrationConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://moviesdb5.p.rapidapi.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("x-rapidapi-key", "dfd65da797msh951cbae34bac09cp1842ecjsn01741c7c2f4c")
                .defaultHeader("x-rapidapi-host", "moviesdb5.p.rapidapi.com")
                .build();
    }
}

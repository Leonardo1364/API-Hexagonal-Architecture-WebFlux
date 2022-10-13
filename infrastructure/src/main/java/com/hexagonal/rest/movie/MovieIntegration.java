package com.hexagonal.rest.movie;

import com.hexagonal.rest.movie.model.MovieIntegrationModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class MovieIntegration {

    private final WebClient webClient;

    public Mono<MovieIntegrationModel> fetchMovie(String title) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/om")
                        .queryParam("t", title)
                        .build())
                .retrieve()
                .bodyToMono(MovieIntegrationModel.class);
    }
}

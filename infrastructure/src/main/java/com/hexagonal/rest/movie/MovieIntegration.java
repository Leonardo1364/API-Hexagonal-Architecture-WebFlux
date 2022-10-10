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

    public Mono<MovieIntegrationModel> fetchMovie(String id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(id)
                        .build())
                .retrieve()
                .bodyToMono(MovieIntegrationModel.class);
    }
}

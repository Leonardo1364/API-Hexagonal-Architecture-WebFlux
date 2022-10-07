package com.hexagonal.adapters;

import com.hexagonal.movie.model.MovieResponseModel;
import com.hexagonal.movie.port.spi.MovieSpiPort;
import com.hexagonal.rest.movie.MovieIntegration;
import com.hexagonal.rest.movie.mapper.MovieMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class MovieSpiImpl implements MovieSpiPort {

    private final MovieIntegration movieIntegration;

    @Override
    public Mono<MovieResponseModel> findMovie(String id) {
        return movieIntegration.fetchMovie(id)
                .map(MovieMapper::mapToDomain);
    }
}

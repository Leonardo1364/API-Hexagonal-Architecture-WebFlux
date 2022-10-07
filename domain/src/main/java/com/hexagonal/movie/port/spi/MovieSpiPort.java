package com.hexagonal.movie.port.spi;

import com.hexagonal.movie.model.MovieResponseModel;
import reactor.core.publisher.Mono;

public interface MovieSpiPort {

    Mono<MovieResponseModel> findMovie(String id);
}

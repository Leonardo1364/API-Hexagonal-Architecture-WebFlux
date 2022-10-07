package com.hexagonal.movie.port.api;

import com.hexagonal.movie.model.MovieResponseModel;
import reactor.core.publisher.Mono;

public interface MovieApiPort {

    Mono<MovieResponseModel> fetchMovie(String id);
}

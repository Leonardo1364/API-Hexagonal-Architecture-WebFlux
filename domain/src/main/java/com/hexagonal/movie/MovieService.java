package com.hexagonal.movie;

import com.hexagonal.movie.model.MovieResponseModel;
import com.hexagonal.movie.port.api.MovieApiPort;
import com.hexagonal.movie.port.spi.MovieSpiPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MovieService implements MovieApiPort {

    private MovieSpiPort movieSpiPort;

    @Override
    public Mono<MovieResponseModel> fetchMovie(String id) {
        return movieSpiPort.findMovie(id);
    }
}

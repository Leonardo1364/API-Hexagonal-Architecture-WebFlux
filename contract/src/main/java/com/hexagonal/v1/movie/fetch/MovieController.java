package com.hexagonal.v1.movie.fetch;

import com.hexagonal.movie.model.MovieResponseModel;
import com.hexagonal.movie.port.api.MovieApiPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("/v1/movie")
@RestController
@AllArgsConstructor
public class MovieController {

    private MovieApiPort movieApiPort;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<MovieResponseModel> fetchOneMovie(@PathVariable("id") String id) {
        return movieApiPort.fetchMovie(id);
    }
}

package com.hexagonal.rest.movie.mapper;

import com.hexagonal.movie.model.MovieResponseModel;
import com.hexagonal.rest.movie.model.MovieIntegrationModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieMapper {

    public static MovieResponseModel mapToDomain(MovieIntegrationModel movieIntegrationModel) {
        return Optional.ofNullable(movieIntegrationModel)
                .map(movieIntegrationModel1 -> MovieResponseModel.builder()
                        .title(movieIntegrationModel.getTitle())
                        .year(movieIntegrationModel.getYear())
                        .genre(movieIntegrationModel.getGenre())
                        .plot(movieIntegrationModel.getPlot())
                        .type(movieIntegrationModel.getType())
                        .build())
                .orElse(null);
    }
}

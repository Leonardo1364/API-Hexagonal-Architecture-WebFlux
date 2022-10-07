package com.hexagonal.rest.movie.mapper;

import com.hexagonal.movie.model.MovieResponseModel;
import com.hexagonal.movie.model.RatingResponseModel;
import com.hexagonal.rest.movie.model.MovieIntegrationModel;
import com.hexagonal.rest.movie.model.RatingIntegrationModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieMapper {

    public static MovieResponseModel mapToDomain(MovieIntegrationModel movieIntegrationModel) {
        return Optional.ofNullable(movieIntegrationModel)
                .map(movieIntegrationModel1 -> MovieResponseModel.builder()
                        .title(movieIntegrationModel.getTitle())
                        .year(movieIntegrationModel.getYear())
                        .rated(movieIntegrationModel.getRated())
                        .released(movieIntegrationModel.getReleased())
                        .runtime(movieIntegrationModel.getRuntime())
                        .genre(movieIntegrationModel.getGenre())
                        .director(movieIntegrationModel.getDirector())
                        .writer(movieIntegrationModel.getWriter())
                        .actors(movieIntegrationModel.getActors())
                        .plot(movieIntegrationModel.getPlot())
                        .language(movieIntegrationModel.getLanguage())
                        .country(movieIntegrationModel.getCountry())
                        .awards(movieIntegrationModel.getAwards())
                        .poster(movieIntegrationModel.getPoster())
                        .ratings(mapToDomainService(movieIntegrationModel.getRatings()))
                        .metaScore(movieIntegrationModel.getMetaScore())
                        .imdbRating(movieIntegrationModel.getImdbRating())
                        .imdbVotes(movieIntegrationModel.getImdbVotes())
                        .imdbID(movieIntegrationModel.getImdbID())
                        .type(movieIntegrationModel.getType())
                        .dvd(movieIntegrationModel.getDvd())
                        .boxOffice(movieIntegrationModel.getBoxOffice())
                        .production(movieIntegrationModel.getProduction())
                        .website(movieIntegrationModel.getWebsite())
                        .response(movieIntegrationModel.getResponse())
                        .build())
                .orElse(null);
    }

    public static List<RatingResponseModel> mapToDomainService(List<RatingIntegrationModel> ratingIntegrationModel) {
        return ratingIntegrationModel.stream()
                .map((RatingIntegrationModel rating) -> RatingResponseModel.builder()
                        .source(rating.getSource())
                        .value(rating.getValue())
                        .build())
                .toList();
    }
}

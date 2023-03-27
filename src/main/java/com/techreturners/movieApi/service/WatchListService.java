package com.techreturners.movieApi.service;

import com.techreturners.movieApi.vo.Movie;
import com.techreturners.movieApi.vo.Movies;

import java.util.List;

public interface WatchListService {
    List<Movie> getMovieDetails();

    Movie saveMovies(Movie movie);

    void deleteMovieByImdbId(String imdbId);
}

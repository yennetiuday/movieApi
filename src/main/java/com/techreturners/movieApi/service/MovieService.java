package com.techreturners.movieApi.service;

import com.techreturners.movieApi.dao.MovieDao;
import com.techreturners.movieApi.vo.Movies;

import java.io.IOException;
import java.util.Optional;

public interface MovieService {

    void saveMovies() throws IOException;

    Optional<MovieDao> getMovieByYear(Long year);

    Movies getMoviesFromApi() throws IOException;
}

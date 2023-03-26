package com.techreturners.movieApi.service;

import com.techreturners.movieApi.vo.Movies;

import java.io.IOException;
import java.util.Optional;

public interface MovieService {
    Movies getMovieByYear(Long year, Integer page) throws Exception;

    Movies  getMovieOrderByRating() throws Exception;
    Movies getMovieIdByTitle(String title) throws Exception;

}

package com.techreturners.movieApi.service;

import com.techreturners.movieApi.vo.Movies;

public interface MovieService {
    Movies getMovieByYear(Long year, Integer page) throws Exception;
    Movies  getMovieOrderByRating(Integer page) throws Exception;
    Movies getMovieIdByTitle(String title) throws Exception;
    Movies getMoviesByGenre(String genre, Integer page) throws Exception;

}

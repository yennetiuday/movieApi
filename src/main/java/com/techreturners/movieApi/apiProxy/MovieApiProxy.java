package com.techreturners.movieApi.apiProxy;

import com.techreturners.movieApi.vo.Movies;

import java.io.IOException;

public interface MovieApiProxy {

    Movies retriveMoviesByYear(Long year, Integer page) throws IOException;
    Movies retriveMoviesOrderByRating(Integer page) throws IOException;
    Movies retriveMovieIdByTitle(String title) throws IOException;
    Movies retriveMoviesByGenre(String genre, Integer page) throws IOException;
}

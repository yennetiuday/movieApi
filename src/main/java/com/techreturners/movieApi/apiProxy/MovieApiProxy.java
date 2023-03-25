package com.techreturners.movieApi.apiProxy;

import com.techreturners.movieApi.vo.Movies;

import java.io.IOException;

public interface MovieApiProxy {

    Movies retriveMoviesByYear(Long year, Integer page) throws IOException;
}

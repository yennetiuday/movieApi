package com.techreturners.movieApi.service;

import com.techreturners.movieApi.vo.Movies;

import java.io.IOException;
import java.util.Optional;

public interface MovieService {
    Movies getMovieByYear(Long year) throws Exception;

}

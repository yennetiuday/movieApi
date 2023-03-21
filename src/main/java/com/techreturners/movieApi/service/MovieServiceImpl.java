package com.techreturners.movieApi.service;


import com.techreturners.movieApi.apiProxy.MovieApiProxy;
import com.techreturners.movieApi.repository.MovieRepository;
import com.techreturners.movieApi.vo.Movie;
import com.techreturners.movieApi.vo.Movies;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieApiProxy movieApiProxy;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movies getMovieByYear(Long year) throws IOException {
        return movieApiProxy.retriveMoviesByYear(year);
    }
}


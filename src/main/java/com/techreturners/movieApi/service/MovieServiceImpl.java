package com.techreturners.movieApi.service;


import com.techreturners.movieApi.apiProxy.MovieApiProxy;
import com.techreturners.movieApi.vo.Movies;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieApiProxy movieApiProxy;

    @Override
    public Movies getMovieByYear(Long year) throws IOException {
        return movieApiProxy.retriveMoviesByYear(year);
    }
}


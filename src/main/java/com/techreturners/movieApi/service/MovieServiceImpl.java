package com.techreturners.movieApi.service;


import com.techreturners.movieApi.dao.MovieDao;
import com.techreturners.movieApi.repository.GenreRepository;
import com.techreturners.movieApi.repository.MovieRepository;
import com.techreturners.movieApi.vo.Movies;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;


    @Override
    public void saveMovies() throws IOException {

    }

    @Override
    public Optional<MovieDao> getMovieByYear(Long year) {
        Optional<MovieDao> movies = movieRepository.findByYear(year);
        return movies;
    }

    @Override
    public Movies getMoviesFromApi() throws IOException {
        return null;
    }
}

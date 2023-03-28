package com.techreturners.movieApi.service;

import com.techreturners.movieApi.apiProxy.MovieApiProxy;
import com.techreturners.movieApi.vo.Genre;
import com.techreturners.movieApi.vo.Movies;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieApiProxy movieApiProxy;

    @Autowired
    GenreService genreService;

    @Override
    public Movies getMovieByYear(Long year, Integer page) throws IOException {
        return movieApiProxy.retriveMoviesByYear(year, page);
    }

    @Override
    public Movies getMovieOrderByRating(Integer page) throws IOException{
        return movieApiProxy.retriveMoviesOrderByRating(page);
    }

    @Override
    public Movies getMovieIdByTitle(String title) throws IOException{
        return movieApiProxy.retriveMovieIdByTitle(title);
    }

    @Override
    public Movies getMoviesByGenre(String genreName, Integer page) throws Exception {
        Genre genre = genreService.getGenreByName(genreName);
        if(Objects.nonNull(genre)) {
            return movieApiProxy.retriveMoviesByGenre(genre.getGenre(), page);
        }
        return Movies.builder().build();
    }
}


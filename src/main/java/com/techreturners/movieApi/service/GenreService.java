package com.techreturners.movieApi.service;

import com.techreturners.movieApi.vo.Genre;
import com.techreturners.movieApi.vo.Genres;

import java.io.IOException;

public interface GenreService {
    void saveGenres() throws IOException;
    Genres getGenres();
    Genre getGenreByName(String genre);
}

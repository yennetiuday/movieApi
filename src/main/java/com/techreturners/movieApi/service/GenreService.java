package com.techreturners.movieApi.service;

import com.techreturners.movieApi.vo.Genres;

import java.io.IOException;

public interface GenreService {
    void saveGenres() throws IOException;

    Genres getGenres();

    Genres getGenresFromApi() throws IOException;
}

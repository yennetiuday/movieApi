package com.techreturners.movieApi.apiProxy;

import com.techreturners.movieApi.vo.Genres;

import java.io.IOException;

public interface GenreApiProxy {
    Genres retrieveGenres() throws IOException;
}

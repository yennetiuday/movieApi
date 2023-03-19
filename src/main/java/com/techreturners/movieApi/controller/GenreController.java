package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.GenreService;
import com.techreturners.movieApi.vo.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping
    public Genres getAllGenres() throws IOException {
        return genreService.getGenres();
    }
}

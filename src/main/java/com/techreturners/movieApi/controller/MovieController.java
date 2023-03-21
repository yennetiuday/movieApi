package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.MovieService;
import com.techreturners.movieApi.vo.Movies;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping
    @RequestMapping(path = "{movies}")
    public ResponseEntity<?> getMovieByYear(@PathVariable("movies") Long year) {
        Movies movies;
        try
        {
            movies = movieService.getMovieByYear(year);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving Movies.");
        }
    }
}

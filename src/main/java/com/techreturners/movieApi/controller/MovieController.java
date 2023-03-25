package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.MovieService;
import com.techreturners.movieApi.vo.Movies;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping(path="{year}")
    public ResponseEntity<?> getMovieByYear(@PathVariable("year") Long year,
                                            @RequestParam(value = "page", defaultValue = "1") int page) {
        Movies movies;
        try {
            movies = movieService.getMovieByYear(year, page);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving Movies.");
        }
    }
}

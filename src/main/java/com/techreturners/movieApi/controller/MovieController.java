package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.dao.MovieDao;
import com.techreturners.movieApi.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("movies")
@AllArgsConstructor
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping({"/{year}"})
    public Optional<MovieDao> getMovieByYear(@PathVariable Long year){
        return movieService.getMovieByYear(year);
    }
}

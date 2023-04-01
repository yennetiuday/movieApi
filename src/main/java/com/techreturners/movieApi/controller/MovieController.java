package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.MovieService;
import com.techreturners.movieApi.vo.Movies;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

  @GetMapping(path = "byYear/{year}")
  @Operation(security = @SecurityRequirement(name = "bearerAuth"))
  public ResponseEntity<?> getMovieByYear(
      @PathVariable("year") Long year, @RequestParam(value = "page", defaultValue = "1") int page) {
        Movies movies;
        try {
            movies = movieService.getMovieByYear(year, page);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving Movies.");
        }
    }

    @GetMapping({"order/byRating"})
    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> getMovieOrderByRating(@RequestParam(value = "page", defaultValue = "1") int page) {
        Movies movies;
        try {
            movies = movieService.getMovieOrderByRating(page);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving Movies Order by Rating.");
        }
    }

    @GetMapping({"imdb_id/byTitle/{title}"})
    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> getMovieIdByTitle(@PathVariable("title") String title) {
        Movies movies;
        try{
            movies = movieService.getMovieIdByTitle(title);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving Movies Id by Title.");
        }
    }

    @GetMapping({"byGenre/{genre}"})
    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> getMovieIdByGenre(@PathVariable("genre") String genre,
                                               @RequestParam(value = "page", defaultValue = "1") int page) {
        Movies movies;
        try{
            movies = movieService.getMoviesByGenre(genre, page);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving Movies Id by Title.");
        }
    }
}

package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.GenreService;
import com.techreturners.movieApi.vo.Genres;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

  @GetMapping
  @Operation(security = @SecurityRequirement(name = "bearerAuth"))
  public ResponseEntity<?> getAllGenres() {
        Genres genres;
        try {
            genres = genreService.getGenres();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving genres.");
        }
        return ResponseEntity.ok(genres);
    }
}

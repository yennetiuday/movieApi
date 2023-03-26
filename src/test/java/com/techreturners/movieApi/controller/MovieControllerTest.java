package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.MovieServiceImpl;
import com.techreturners.movieApi.vo.Movie;
import com.techreturners.movieApi.vo.Movies;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieControllerTest {

    @Mock
    MovieServiceImpl movieService;
    @InjectMocks
    MovieController movieController;

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnMovieByYear() throws IOException {
        Long year = 2022L;
        Movies movies = new Movies();
//        Movie movie = Movie.builder().title("Movie1")..build();
//        movies.setTitle("Movie1");
//        movies.setYear(year);
//
//        when(movieService.getMovieByYear(year)).thenReturn(movies);
//
//        ResponseEntity<?> responseEntity = movieController.getMovieByYear(year);
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isEqualTo(movies);
    }

    @Test
    void shouldReturnInternalServerError() throws IOException {
        Long year = 2022L;

//        when(movieService.getMovieByYear(year)).thenThrow(new RuntimeException("Error Retrieving Movies."));
//
//        ResponseEntity<?> responseEntity = movieController.getMovieByYear(year);
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
//        assertThat(responseEntity.getBody()).isEqualTo("Error Retrieving Movies.");
    }
}

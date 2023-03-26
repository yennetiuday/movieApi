package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.MovieServiceImpl;
import com.techreturners.movieApi.vo.Movie;
import com.techreturners.movieApi.vo.Movies;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class
MovieControllerTest {

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

    @Test
    void ShouldReturnMovieOrderByRating() throws Exception{
        List<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder().imdb_id("1").title("test").rating(9.1f).build());

        Movies expectedMovies = Movies.builder().results(movies).build();

        Mockito.when(movieService.getMovieOrderByRating()).thenReturn(expectedMovies);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/movie/order/byRating/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
              //  .andExpect(MockMvcResultMatchers.jsonPath("results[0].imdb_id").value(""))
               // .andExpect(MockMvcResultMatchers.jsonPath("results[0].title").value("test"))
                //.andExpect(MockMvcResultMatchers.jsonPath("results[0].rating").value(9.1f));

    }

    @Test
    void ShouldReturnMovieIdByTitle() throws Exception{
        List<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder().imdb_id("1").title("test").build());

        Movies expectedMovies = Movies.builder().results(movies).build();
        Mockito.when(movieService.getMovieIdByTitle(Mockito.anyString())).thenReturn(expectedMovies);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/movie/order/byRating/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("results[0].imdb_id").value("tt10942302"));





    }

}

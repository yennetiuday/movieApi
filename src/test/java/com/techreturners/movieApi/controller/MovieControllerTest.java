package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.MovieService;
import com.techreturners.movieApi.service.MovieServiceImpl;
import com.techreturners.movieApi.vo.Movie;
import com.techreturners.movieApi.vo.Movies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class
MovieControllerTest {

    @Mock
    MovieServiceImpl movieService;
    @Mock
    private MovieService movieServiceMock;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

  @WithMockUser(value = "spring")
  @Test
  public void getMovieByYear_shouldReturnOkResponseWhenMovieServiceReturnsMovies()
      throws Exception {
        // Arrange
        Long year = 2022L;
        int page = 1;
        List<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder().imdb_id("1").title("test").build());
        Movies expectedMovies = Movies.builder().results(movies).build();

        Mockito.when(movieServiceMock.getMovieByYear(year, page)).thenReturn(expectedMovies);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/movie/byYear/" + year))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void ShouldReturnMovieOrderByRating() throws Exception{
        List<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder().imdb_id("1").title("test").rating(9.1f).build());

        Movies expectedMovies = Movies.builder().results(movies).build();

        Mockito.when(movieService.getMovieOrderByRating(Mockito.anyInt())).thenReturn(expectedMovies);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/order/byRating"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @WithMockUser(value = "spring")
    @Test
    void ShouldReturnMovieIdByTitle() throws Exception{
        List<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder().imdb_id("1").title("test").build());

        Movies expectedMovies = Movies.builder().results(movies).build();
        Mockito.when(movieService.getMovieIdByTitle(Mockito.anyString())).thenReturn(expectedMovies);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/imdb_id/byTitle/test"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void TestReturnMoviesByGenre() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder().imdb_id("1").title("test").build());

        Movies expectedMovies = Movies.builder().results(movies).build();
        Mockito.when(movieService.getMoviesByGenre(Mockito.anyString(), Mockito.anyInt())).thenReturn(expectedMovies);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/byGenre/test"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

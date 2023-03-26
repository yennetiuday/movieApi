package com.techreturners.movieApi.service;

import com.techreturners.movieApi.apiProxy.MovieApiProxy;
import com.techreturners.movieApi.vo.Movie;
import com.techreturners.movieApi.vo.Movies;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieServiceImplTest {
    @Mock
    private MovieApiProxy movieApiProxy;
    @InjectMocks
    private MovieServiceImpl movieServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnMoviesByYear() throws IOException {
        Long year = 2022L;
        Movies movies = new Movies();
//        movies.setTitle("Movie1");
//        movies.setYear(year);
//
//        when(movieApiProxy.retriveMoviesByYear(year)).thenReturn(movies);
//
//        Movies actualMovies = movieServiceImpl.getMovieByYear(year);
//        assertThat(actualMovies).isEqualTo(movies);
    }



    @Test
    void testMovieOrderByRating() throws Exception{
        List<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder().imdb_id("1").title("test").rating(9.1f).build());
        Movies expectedMovies = Movies.builder().results(movies).build();

        Mockito.when(movieApiProxy.retriveMoviesOrderByRating()).thenReturn(expectedMovies);


        Movies actualMovies = movieServiceImpl.getMovieOrderByRating();

        Assertions.assertThat(actualMovies).isEqualTo(expectedMovies);
        Assertions.assertThat(actualMovies.getResults().size()).isEqualTo(1);
        Assertions.assertThat(actualMovies.getResults().get(0).getTitle()).isEqualTo("test");
        Assertions.assertThat(actualMovies.getResults().get(0).getImdb_id()).isEqualTo("1");
    }

    @Test
    void testMovieIdByTitle() throws Exception{
        List<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder().imdb_id("1").title("test").build());


        Movies expectedMovies = Movies.builder().results(movies).build();
        Mockito.when((movieApiProxy.retriveMovieIdByTitle(Mockito.anyString()))).thenReturn(expectedMovies);

        Movies actualMovies = movieServiceImpl.getMovieIdByTitle("test");
        Assertions.assertThat(actualMovies).isEqualTo(expectedMovies);
        Assertions.assertThat(actualMovies.getResults().size()).isEqualTo(1);
        Assertions.assertThat(actualMovies.getResults().get(0).getTitle()).isEqualTo("test");
        Assertions.assertThat(actualMovies.getResults().get(0).getImdb_id()).isEqualTo("1");
    }
}









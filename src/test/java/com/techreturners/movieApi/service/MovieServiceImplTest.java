package com.techreturners.movieApi.service;

import com.techreturners.movieApi.apiProxy.MovieApiProxy;
import com.techreturners.movieApi.repository.MovieRepository;
import com.techreturners.movieApi.vo.Movies;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.io.IOException;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieServiceImplTest {
    @Mock
    private MovieApiProxy movieApiProxy;

    @Mock
    private MovieRepository movieRepository;

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
        movies.setTitle("Movie1");
        movies.setYear(year);

        when(movieApiProxy.retriveMoviesByYear(year)).thenReturn(movies);

        Movies actualMovies = movieServiceImpl.getMovieByYear(year);
        assertThat(actualMovies).isEqualTo(movies);
    }
}









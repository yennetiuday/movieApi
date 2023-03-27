package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.WatchListService;
import com.techreturners.movieApi.vo.Movie;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WatchListControllerTest {

    @Mock
    private WatchListService watchListService;

    @InjectMocks
    private WatchListController watchListController;

    @Test
    public void testGetMovies() throws Exception {
        // create a list of movies to be returned by the service
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie("tt1234567", "Movie 1", null);
        Movie movie2 = new Movie("tt2345678", "Movie 2", null);
        movies.add(movie1);
        movies.add(movie2);

        // mock the behavior of the service
        when(watchListService.getMovieDetails()).thenReturn(movies);

        // call the controller method
        ResponseEntity<?> response = watchListController.getMovies();

        // assert the response
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(movies, response.getBody());
    }

    @Test
    public void testSaveMoviesToWatchList() {
        // Prepare test data
        Movie movie = new Movie("Title 1", "tt000001", null);

        // Call the controller method
        ResponseEntity<Movie> response = watchListController.saveMoviesToWatchList(movie);

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movie, response.getBody());

        // Verify that the service method was called
        verify(watchListService, times(1)).saveMovies(any(Movie.class));
    }

    @Test
    public void testDeleteMovie() {
        // Prepare test data
        String imdbId = "tt000001";

        // Call the controller method
        ResponseEntity<Void> response = watchListController.deleteMovie(imdbId);

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verify that the service method was called
        verify(watchListService, times(1)).deleteMovieByImdbId(imdbId);
    }
}

package com.techreturners.movieApi.service;

import com.techreturners.movieApi.dao.WatchListDao;
import com.techreturners.movieApi.repository.WatchListRepository;
import com.techreturners.movieApi.vo.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WatchListServiceImplTest {

    @Mock
    private WatchListRepository watchListRepository;

    @InjectMocks
    private WatchListServiceImpl watchListService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMovieDetails() {
        List<WatchListDao> daoList = new ArrayList<>();
        daoList.add(new WatchListDao("tt123", "Test Movie 1"));
        daoList.add(new WatchListDao("tt456", "Test Movie 2"));
        when(watchListRepository.findAll()).thenReturn(daoList);

        List<Movie> movies = watchListService.getMovieDetails();

        verify(watchListRepository).findAll();
        assertEquals(2, movies.size());
        assertEquals("tt123", movies.get(0).getImdb_id());
        assertEquals("Test Movie 1", movies.get(0).getTitle());
        assertEquals("tt456", movies.get(1).getImdb_id());
        assertEquals("Test Movie 2", movies.get(1).getTitle());
    }

    @Test
    public void testSaveMovies() {
        // Mocking the repository to return a WatchListDao object
        when(watchListRepository.save(any(WatchListDao.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Creating a Movie object to save
        Movie movie = new Movie("Title 1", "tt000001", null);
        movie.setTitle("Title 1");
        movie.setImdb_id("tt000001");

        // Call the service method to save the movie
        Movie savedMovie = watchListService.saveMovies(movie);

        // Verify that the repository method was called
        verify(watchListRepository, times(1)).save(any(WatchListDao.class));

        // Verify that the service method returned the original Movie object
        assertEquals(savedMovie, movie);
    }

    @Test
    public void testDeleteMovieByImdbId() {
        // Mocking the repository to return a WatchListDao object
        WatchListDao dao = new WatchListDao("Title 1", "tt000001");
        when(watchListRepository.findByImdbId("tt000001")).thenReturn(dao);

        // Call the service method to delete the movie
        watchListService.deleteMovieByImdbId("tt000001");

        // Verify that the repository method was called
        verify(watchListRepository, times(1)).findByImdbId("tt000001");
        verify(watchListRepository, times(1)).delete(dao);
    }
}

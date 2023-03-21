package com.techreturners.movieApi.service;

import com.techreturners.movieApi.dao.GenreDao;
import com.techreturners.movieApi.repository.GenreRepository;
import com.techreturners.movieApi.vo.Genres;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
public class GenreServiceImplTest {

    @Mock
    private GenreRepository mockGenreRepository;

    @InjectMocks
    private GenreServiceImpl genreService;

    @Test
    void saveGenres() {
    }

    @Test
    void getGenres() {
        List<GenreDao> genreList = new ArrayList<>();
        genreList.add(new GenreDao(1L, "Action"));
        genreList.add(new GenreDao(2L, "Fiction"));
        genreList.add(new GenreDao(3L, "Animation"));

        when(mockGenreRepository.findAll()).thenReturn(genreList);

        Genres actualResult = genreService.getGenres();

        assertThat(actualResult.getResults()).hasSize(3);
    }
}
package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.GenreServiceImpl;
import com.techreturners.movieApi.vo.Genre;
import com.techreturners.movieApi.vo.Genres;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
class GenreControllerTest {

    @Mock
    private GenreServiceImpl genreService;

    @InjectMocks
    private GenreController genreController;

    @Autowired
    private MockMvc mockMvcController;

    @BeforeEach
    public void setUp() {
        mockMvcController = MockMvcBuilders.standaloneSetup(genreController).build();
    }

  @WithMockUser(value = "spring")
  @Test
  void testGetAllGenres() throws Exception {

        List<Genre> results = new ArrayList<>();
        results.add(new Genre("Action"));
        results.add(new Genre("Fiction"));
        results.add(new Genre("Animated"));
        Genres genres = Genres.builder().results(results).build();

        Mockito.when(genreService.getGenres()).thenReturn(genres);

        this.mockMvcController.perform(MockMvcRequestBuilders.get("/api/v1/genres/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("results[0].genre").value("Action"))
                .andExpect(MockMvcResultMatchers.jsonPath("results[1].genre").value("Fiction"))
                .andExpect(MockMvcResultMatchers.jsonPath("results[2].genre").value("Animated"));
    }
}
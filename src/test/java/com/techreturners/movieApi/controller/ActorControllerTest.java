package com.techreturners.movieApi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.movieApi.service.ActorServiceImpl;
import com.techreturners.movieApi.vo.Actor;
import com.techreturners.movieApi.vo.Actors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class ActorControllerTest {

    @Mock
    private ActorServiceImpl actorService;

    @InjectMocks
    private ActorController actorController;

    @Autowired
    private MockMvc mockMvcController;

    @BeforeEach
    public void setUp() {
        mockMvcController = MockMvcBuilders.standaloneSetup(actorController).build();
    }

    @Test
    void testGetActorsByName() throws Exception {
        List<Actor> actors = new ArrayList<>();
        actors.add(Actor.builder().imdb_id("1").name("test").build());
        Actors expectedActors = Actors.builder().results(actors).build();

        Mockito.when(actorService.getActorByName(Mockito.anyString())).thenReturn(expectedActors);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/actor/" + "test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("results[0].name").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("results[0].imdb_id").value("1"));
    }
}
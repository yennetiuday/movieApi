package com.techreturners.movieApi.service;

import com.techreturners.movieApi.apiProxy.ActorApiProxy;
import com.techreturners.movieApi.vo.Actor;
import com.techreturners.movieApi.vo.Actors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class ActorServiceImplTest {

    @Mock
    private ActorApiProxy actorApiProxy;

    @InjectMocks
    private ActorServiceImpl actorService;

    @Test
    void testGetActorByName() throws IOException {
        List<Actor> actors = new ArrayList<>();
        actors.add(Actor.builder().imdb_id("1").name("test").build());
        Actors expectedActors = Actors.builder().results(actors).build();
        Mockito.when(actorApiProxy.retrieveActors(Mockito.anyString())).thenReturn(expectedActors);

        Actors actualActors = actorService.getActorByName("test");

        Assertions.assertThat(actualActors).isEqualTo(expectedActors);
        Assertions.assertThat(actualActors.getResults().size()).isEqualTo(1);
        Assertions.assertThat(actualActors.getResults().get(0).getName()).isEqualTo("test");
        Assertions.assertThat(actualActors.getResults().get(0).getImdb_id()).isEqualTo("1");
    }

    @Test
    void testGetActorDetailsByImdbId() throws IOException {
        List<Actor> actors = new ArrayList<>();
        actors.add(Actor.builder().imdb_id("1").name("test").image_url("test url").type("Person")
                .birth_date("1956-07-09").birth_place("test place").partial_bio("test bio")
                .height("1.83 m").star_sigh("test sign").build());
        Actors expectedActors = Actors.builder().results(actors).build();
        Mockito.when(actorApiProxy.retrieveActorDetailsById(Mockito.anyString())).thenReturn(expectedActors);

        Actors actualActors = actorService.getActorDetailsByImdbId("1");

        Assertions.assertThat(actualActors).isEqualTo(expectedActors);
    }
}
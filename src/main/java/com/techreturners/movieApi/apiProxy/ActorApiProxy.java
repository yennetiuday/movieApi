package com.techreturners.movieApi.apiProxy;

import com.techreturners.movieApi.vo.Actors;

import java.io.IOException;

public interface ActorApiProxy {
    Actors retrieveActors(String name) throws IOException;

    Actors retrieveActorDetailsById(String imdbId) throws IOException;
}

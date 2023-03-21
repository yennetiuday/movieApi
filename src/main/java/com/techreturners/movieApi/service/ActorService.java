package com.techreturners.movieApi.service;

import com.techreturners.movieApi.vo.Actors;

import java.io.IOException;

public interface ActorService {

    Actors getActorByName(String name) throws IOException;

    Actors getActorDetailsByImdbId(String imdbId) throws IOException;
}

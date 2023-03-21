package com.techreturners.movieApi.service;

import com.techreturners.movieApi.apiProxy.ActorApiProxy;
import com.techreturners.movieApi.vo.Actors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorApiProxy actorApiProxy;

    @Override
    public Actors getActorByName(String name) throws IOException {
        return actorApiProxy.retrieveActors(name);
    }

    @Override
    public Actors getActorDetailsByImdbId(String imdbId) throws IOException {
        return actorApiProxy.retrieveActorDetailsById(imdbId);
    }
}

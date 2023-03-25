package com.techreturners.movieApi.controller;

import com.techreturners.movieApi.service.ActorService;
import com.techreturners.movieApi.vo.Actors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping(path = "{name}")
    public ResponseEntity<?> getActorsByName(@PathVariable("name") String name) {
        Actors actors;
        try {
            actors = actorService.getActorByName(name);
            return ResponseEntity.ok(actors);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving Actor(s).");
        }
    }
}

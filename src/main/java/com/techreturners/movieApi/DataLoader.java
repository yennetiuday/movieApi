package com.techreturners.movieApi;

import com.techreturners.movieApi.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    @Autowired
    GenreService genreService;

    @Override
    public void run(String... args) throws Exception {
        genreService.saveGenres();
    }
}

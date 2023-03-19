package com.techreturners.movieApi.vo;

import com.techreturners.movieApi.dao.MovieDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    String movie;

    public Movie convertDao(MovieDao dao) {
        return new Movie(dao.getName());
    }
}

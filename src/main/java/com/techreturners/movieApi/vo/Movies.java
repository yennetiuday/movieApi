package com.techreturners.movieApi.vo;

import com.techreturners.movieApi.dao.MovieDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movies {
    List<Movie> results;

    public List<MovieDao> convertToDao(Movies movies){
        List<MovieDao> movieDaos = new ArrayList<>();
        for(Movie movie: movies.getResults()){
            movieDaos.add(MovieDao.builder().name(movie.getMovie()).build());
        }
        return movieDaos;
    }
}

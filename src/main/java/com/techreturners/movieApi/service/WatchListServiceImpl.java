package com.techreturners.movieApi.service;

import com.techreturners.movieApi.dao.WatchListDao;
import com.techreturners.movieApi.repository.WatchListRepository;
import com.techreturners.movieApi.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class WatchListServiceImpl implements WatchListService{

    @Autowired
    private WatchListRepository watchListRepository;
    @Override
    public List<Movie> getMovieDetails() {
        List<Movie> watchListmovies = new ArrayList<>();
        for (WatchListDao watchListDao : watchListRepository.findAll()) {
            watchListmovies.add(Movie.convertDaoToVo(watchListDao));
        }
        return watchListmovies;
    }

    @Override
    public Movie saveMovies(Movie movie) {
        WatchListDao dao = WatchListDao.builder().title(movie.getTitle())
                .imdbId(movie.getImdb_id()).build();
        watchListRepository.save(dao);
        return movie;
    }
    @Override
    public void deleteMovieByImdbId(String imdbId) {
        WatchListDao watchListDao = watchListRepository.findByImdbId(imdbId);
        if(Objects.nonNull(watchListDao)) {
            watchListRepository.delete(watchListDao);
        }
    }
}

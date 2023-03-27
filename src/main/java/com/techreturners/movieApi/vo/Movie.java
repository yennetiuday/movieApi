package com.techreturners.movieApi.vo;

import com.techreturners.movieApi.dao.WatchListDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
     String title;
     String imdb_id;
     Float rating;
    public static Movie convertDaoToVo(WatchListDao watchListDao){
        return Movie.builder().title(watchListDao.getTitle()).imdb_id(watchListDao.getImdbId()).build();
    }
}

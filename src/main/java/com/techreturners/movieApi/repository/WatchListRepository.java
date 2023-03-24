package com.techreturners.movieApi.repository;

import com.techreturners.movieApi.dao.WatchListDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchListRepository extends JpaRepository<WatchListDao, Long> {

    WatchListDao findByMovieName(String movieName);
}

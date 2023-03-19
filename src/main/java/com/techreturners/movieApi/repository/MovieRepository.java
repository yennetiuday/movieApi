package com.techreturners.movieApi.repository;

import com.techreturners.movieApi.dao.MovieDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<MovieDao, Long>,JpaRepository<MovieDao, Long> {

    Optional<MovieDao> findByYear(Long year);
}

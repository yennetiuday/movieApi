package com.techreturners.movieApi.repository;

import com.techreturners.movieApi.dao.GenreDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreDao, Long> {
}

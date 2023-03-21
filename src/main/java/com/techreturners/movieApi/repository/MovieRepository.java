package com.techreturners.movieApi.repository;

import com.techreturners.movieApi.vo.Movies;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movies, String>  {

    Movies findByYear(Long year);
}

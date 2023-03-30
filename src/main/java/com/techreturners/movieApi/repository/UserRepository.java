package com.techreturners.movieApi.repository;

import com.techreturners.movieApi.dao.UserDao;import org.springframework.data.jpa.repository.JpaRepository;import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDao, Integer>{
    Optional<UserDao> findByEmail(String email);
}

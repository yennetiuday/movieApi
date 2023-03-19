package com.techreturners.movieApi.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Movie")
public class MovieDao {
    @Id
    @SequenceGenerator(name = "movie_seq", sequenceName = "movie_seq")
    @GeneratedValue(generator = "movie_seq")
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    Long year;

    @Column(unique = true)
    String name;
}

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
@Table(name = "Genre")
public class GenreDao {
    @Id
    @SequenceGenerator(name = "genre_seq", sequenceName = "genre_seq")
    @GeneratedValue(generator = "genre_seq")
    @Column(updatable = false, nullable = false)
    Long id;

    @Column(unique = true)
    String name;
}

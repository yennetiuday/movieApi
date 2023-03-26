package com.techreturners.movieApi.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "WatchList")
public class WatchListDao {
    @Id
    @SequenceGenerator(name = "watchlist_seq", sequenceName = "watchlist_seq")
    @GeneratedValue(generator = "watchlist_seq")
    @Column(updatable = false, nullable = false)
    Long id;

    @Column(updatable = false, nullable = false)
    Long imdb_id;

    @Column(unique = true)
    String movieName;
}


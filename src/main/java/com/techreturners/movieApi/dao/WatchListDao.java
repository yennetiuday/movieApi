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
@Table(name = "WatchList")
public class WatchListDao {
    @Id
    @SequenceGenerator(name = "watchlist_seq", sequenceName = "watchlist_seq")
    @GeneratedValue(generator = "watchlist_seq")
    @Column(updatable = false, nullable = false)
    Long id;

    @Column(updatable = false, nullable = false)
    String imdbId;

    @Column(unique = true)
    String title;

    public WatchListDao(String imdbId, String title) {
        this.imdbId = imdbId;
        this.title = title;
    }

}


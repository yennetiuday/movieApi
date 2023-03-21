package com.techreturners.movieApi.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movies {
    List<Movie> results;

    public void setTitle(String movie) {
    }

    public void setYear(Long year) {
    }
}

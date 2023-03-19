package com.techreturners.movieApi.vo;

import com.techreturners.movieApi.dao.GenreDao;
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
public class Genres {
    List<Genre> results;
}

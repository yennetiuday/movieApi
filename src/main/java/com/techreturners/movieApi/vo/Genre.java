package com.techreturners.movieApi.vo;

import com.techreturners.movieApi.dao.GenreDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    String genre;

    public Genre convertDaoToVO(GenreDao dao) {
        return new Genre(dao.getName());
    }
}

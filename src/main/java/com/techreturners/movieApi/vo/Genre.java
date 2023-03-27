package com.techreturners.movieApi.vo;

import com.techreturners.movieApi.dao.GenreDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    private String genre;

    public static Genre convertDaoToVO(GenreDao dao) {
        return new Genre(dao.getName());
    }
}

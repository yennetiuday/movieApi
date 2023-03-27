package com.techreturners.movieApi.service;

import com.techreturners.movieApi.apiProxy.GenreApiProxy;
import com.techreturners.movieApi.dao.GenreDao;
import com.techreturners.movieApi.repository.GenreRepository;
import com.techreturners.movieApi.vo.Genre;
import com.techreturners.movieApi.vo.Genres;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreApiProxy genreApiProxy;

    @Autowired
    GenreRepository genreRepository;

    @Override
    public void saveGenres() throws IOException {
        List<GenreDao> genreDaos = new ArrayList<>();
        Genres genres = genreApiProxy.retrieveGenres();
        for (Genre genre: genres.getResults()) {
            GenreDao genreDao = genreRepository.findByName(genre.getGenre());
            if(Objects.isNull(genreDao)) {
                genreDaos.add(GenreDao.builder().name(genre.getGenre()).build());
            }
        }
        genreRepository.saveAll(genreDaos);
    }

    @Override
    public Genres getGenres() {
        List<Genre> genres = new ArrayList<>();
        for (GenreDao genreDao: genreRepository.findAll()) {
            genres.add(Genre.convertDaoToVO(genreDao));
        }
        return Genres.builder().results(genres).build();
    }

    @Override
    public Genre getGenreByName(String genre) {
        GenreDao dao = genreRepository.findByName(genre);
        if(Objects.nonNull(dao)){
            return Genre.builder().genre(dao.getName()).build();
        }
        return null;
    }
}

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

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreApiProxy genreApiProxy;

    @Autowired
    GenreRepository genreRepository;

    @Override
    public void saveGenres() throws IOException {
        Genres genres = genreApiProxy.retrieveGenres();
        genreRepository.saveAll(new Genres().convertToDAO(genres));
    }

    @Override
    public Genres getGenres() {
        List<Genre> genres = new ArrayList<>();
        for (GenreDao genreDao: genreRepository.findAll()) {
            genres.add(new Genre().convertDaoToVO(genreDao));
        }
        return Genres.builder().results(genres).build();
    }

    @Override
    public Genres getGenresFromApi() throws IOException {
        return genreApiProxy.retrieveGenres();
    }
}

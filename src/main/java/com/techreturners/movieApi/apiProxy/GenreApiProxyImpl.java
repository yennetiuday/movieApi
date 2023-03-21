package com.techreturners.movieApi.apiProxy;

import static com.techreturners.movieApi.util.UtilConstants.*;
import com.techreturners.movieApi.vo.Genres;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@NoArgsConstructor
public class GenreApiProxyImpl extends ApiProxyBase<Genres> implements GenreApiProxy {

    @Override
    public Genres retrieveGenres() throws IOException {
        String apiUrl = BASE_URL+ GENRES;

        return retrieveData(apiUrl);
    }

    @Override
    protected Class<Genres> getType() {
        return Genres.class;
    }
}

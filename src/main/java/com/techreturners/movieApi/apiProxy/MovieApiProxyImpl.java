package com.techreturners.movieApi.apiProxy;

import com.techreturners.movieApi.vo.Movies;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.techreturners.movieApi.util.UtilConstants.*;

@Service
@NoArgsConstructor
public class MovieApiProxyImpl extends ApiProxyBase<Movies> implements MovieApiProxy {

    @Override
    public Movies retriveMoviesByYear(Long year) throws IOException {

        String apiUrl = BASE_URL + MOVIES;
        String apiEndpoint = "/?y=" + year;

        return retrieveData(apiUrl+apiEndpoint);
    }

    @Override
    protected Class<Movies> getType() {
        return Movies.class;
    }
}



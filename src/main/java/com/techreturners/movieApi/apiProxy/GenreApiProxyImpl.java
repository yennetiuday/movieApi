package com.techreturners.movieApi.apiProxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.movieApi.Util.Util;
import com.techreturners.movieApi.vo.Genres;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@AllArgsConstructor
public class GenreApiProxyImpl implements GenreApiProxy {

    @Override
    public Genres retrieveGenres() throws IOException {
        String apiUrl = Util.BASE_URL+Util.GENRES;
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.GET.name());
        connection.setRequestProperty(Util.X_RAPIDAPI_KEY, Util.X_RAPIDAPI_KEY_VALUE);
        connection.setRequestProperty(Util.X_RAPIDAPI_HOST, Util.X_RAPIDAPI_HOST_VALUE);
        connection.setRequestProperty(Util.ACCEPT, Util.APPLICATION_JSON);

        int responseCode = connection.getResponseCode();
        if(responseCode != HttpStatus.OK.value()) {
            throw new RuntimeException("Failed: HTTP error Code: "+ responseCode);
        }

        return (new ObjectMapper()).readValue(connection.getInputStream(), Genres.class);
    }
}

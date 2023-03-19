package com.techreturners.movieApi.apiProxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import static com.techreturners.movieApi.Util.UtilConstants.*;
import com.techreturners.movieApi.vo.Genres;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class GenreApiProxyImpl implements GenreApiProxy {

    @Value("${x.rapidapi.key.value}")
    private String X_RAPIDAPI_KEY_VALUE;

    @Override
    public Genres retrieveGenres() throws IOException {
        String apiUrl = BASE_URL+ GENRES;
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.GET.name());
        connection.setRequestProperty(X_RAPIDAPI_KEY, X_RAPIDAPI_KEY_VALUE);
        connection.setRequestProperty(X_RAPIDAPI_HOST, X_RAPIDAPI_HOST_VALUE);
        connection.setRequestProperty(ACCEPT, APPLICATION_JSON);

        int responseCode = connection.getResponseCode();
        if(responseCode != HttpStatus.OK.value()) {
            throw new RuntimeException("Failed: HTTP error Code: "+ responseCode);
        }

        return (new ObjectMapper()).readValue(connection.getInputStream(), Genres.class);
    }
}

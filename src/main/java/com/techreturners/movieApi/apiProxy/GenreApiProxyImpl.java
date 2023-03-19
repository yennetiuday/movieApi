package com.techreturners.movieApi.apiProxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import static com.techreturners.movieApi.Util.UtilConstants.*;
import com.techreturners.movieApi.vo.Genres;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class GenreApiProxyImpl implements GenreApiProxy {

    @Value("${x.rapidapi.key.value}")
    private String X_RAPIDAPI_KEY_VALUE;

    @Override
    public Genres retrieveGenres() throws IOException {
        String apiUrl = BASE_URL+ GENRES;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set(X_RAPIDAPI_KEY, X_RAPIDAPI_KEY_VALUE);
        headers.set(X_RAPIDAPI_HOST, X_RAPIDAPI_HOST_VALUE);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        int responseCode = response.getStatusCode().value();
        if(responseCode != HttpStatus.OK.value()) {
            throw new RuntimeException("Failed: HTTP error Code: "+ responseCode);
        }

        return (new ObjectMapper()).readValue(response.getBody(), Genres.class);
    }
}

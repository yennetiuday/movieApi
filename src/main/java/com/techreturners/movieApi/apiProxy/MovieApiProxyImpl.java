package com.techreturners.movieApi.apiProxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.movieApi.vo.Movies;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static com.techreturners.movieApi.util.UtilConstants.*;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MovieApiProxyImpl implements MovieApiProxy {
    @Value("${x.rapidapi.key.value}")
    private String X_RAPIDAPI_KEY_VALUE;
    @Override
    public Movies retriveMoviesByYear(Long year) throws IOException {

        String apiUrl = BASE_URL + MOVIES;
        String apiEndpoint = "/?y=" + year;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set(X_RAPIDAPI_KEY, X_RAPIDAPI_KEY_VALUE);
        headers.set(X_RAPIDAPI_HOST, X_RAPIDAPI_HOST_VALUE);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl + apiEndpoint, HttpMethod.GET, entity, String.class);

        int responseCode = response.getStatusCode().value();
        if (responseCode != HttpStatus.OK.value()) {
            throw new RuntimeException("Failed: HTTP error Code: " + responseCode);
        }
        return (new ObjectMapper()).readValue(response.getBody(), Movies.class);
    }
}



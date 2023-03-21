package com.techreturners.movieApi.apiProxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static com.techreturners.movieApi.util.UtilConstants.X_RAPIDAPI_HOST;
import static com.techreturners.movieApi.util.UtilConstants.X_RAPIDAPI_HOST_VALUE;
import static com.techreturners.movieApi.util.UtilConstants.X_RAPIDAPI_KEY;

public abstract class ApiProxyBase<T> {

    @Value("${x.rapidapi.key.value}")
    private String X_RAPIDAPI_KEY_VALUE;

    protected T retrieveData(String apiUrl) throws IOException {
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

        return (new ObjectMapper()).readValue(response.getBody(), getType());
    }

    protected abstract Class<T> getType();

}
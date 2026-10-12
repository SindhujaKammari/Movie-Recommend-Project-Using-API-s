package com.movieproject.movieproject.Service_files;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.movieproject.movieproject.DTO.OMDB;
import com.movieproject.movieproject.DTO.UserDTO;
import com.movieproject.movieproject.OmdbProperties;

@Service
public class OMDBService {
    private final RestClient restClient;
    private final String apiKey;

    public OMDBService(RestClient omdbRestClient, OmdbProperties omdbProperties) {
        this.restClient = omdbRestClient;
        this.apiKey = omdbProperties.getApi().getKey();
    }

    public List<OMDB> getResults(UserDTO userDto) {
        if (userDto == null || userDto.getMovieList() == null || userDto.getMovieList().isEmpty()) {
            throw new RuntimeException("Wrong JSON. Please send accurate movie names.");
        }

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("OMDb API key is missing. Configure omdb.api.key.");
        }

        List<OMDB> results = new ArrayList<>();
        for (String title : userDto.getMovieList()) {
            if (title == null || title.isBlank()) {
                continue;
            }

            OMDB movieInfo = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/")
                            .queryParam("t", title)
                            .queryParam("apikey", apiKey)
                            .build())
                    .retrieve()
                    .body(OMDB.class);

            if (movieInfo != null && movieInfo.isResponse()) {
                results.add(movieInfo);
            }
        }

        if (results.isEmpty()) {
            throw new RuntimeException("No movie results found for the provided titles.");
        }

        return results;
    }
}

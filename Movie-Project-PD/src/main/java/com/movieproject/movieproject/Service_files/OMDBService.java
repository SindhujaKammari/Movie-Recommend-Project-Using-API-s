package com.movieproject.movieproject.Service_files;

import java.util.ArrayList;
import java.util.LinkedHashSet;
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

    public List<List<String>> comboGenre(List<OMDB> movieInfo) {
        LinkedHashSet<String> uniqueGenres = new LinkedHashSet<>();
        if (movieInfo != null) {
            for (OMDB movieData : movieInfo) {
                if (movieData == null || movieData.getGenre() == null) {
                    continue;
                }
                for (String genre : movieData.getGenre().split(",")) {
                    String cleanedGenre = genre.strip();
                    if (!cleanedGenre.isEmpty()) {
                        uniqueGenres.add(cleanedGenre);
                    }
                }
            }
        }

        List<String> genres = new ArrayList<>(uniqueGenres);
        List<List<String>> combinations = new ArrayList<>();
        for (int size = genres.size(); size >= 2; size--) {
            int[] indexes = new int[size];
            for (int index = 0; index < size; index++) {
                indexes[index] = index;
            }

            while (true) {
                List<String> combination = new ArrayList<>(size);
                for (int index : indexes) {
                    combination.add(genres.get(index));
                }
                combinations.add(combination);

                int index = size - 1;
                while (index >= 0 && indexes[index] == genres.size() - size + index) {
                    index--;
                }
                if (index < 0) {
                    break;
                }

                indexes[index]++;
                for (int next = index + 1; next < size; next++) {
                    indexes[next] = indexes[next - 1] + 1;
                }
            }
        }
        return combinations;
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

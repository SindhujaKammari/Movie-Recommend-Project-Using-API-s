package com.movieproject.movieproject.Service_files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.movieproject.movieproject.DTO.OMDB;
import com.movieproject.movieproject.DTO.UserDTO;
import com.movieproject.movieproject.OmdbProperties;

@Service
public class OMDBService {
    private final RestClient restClient;
    private final String apiKey;
    private List<String> genreList = new ArrayList<>();

    

    public OMDBService(RestClient omdbRestClient, OmdbProperties omdbProperties) {
        this.restClient = omdbRestClient;
        this.apiKey = omdbProperties.getApi().getKey();
    }

    public List<OMDB> movieData(UserDTO userDto) {
        if (userDto == null || userDto.getMovieList() == null || userDto.getMovieList().isEmpty()) {
            throw new RuntimeException("Wrong JSON. Please send accurate movie names.");
        }

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("OMDb API key is missing. Configure omdb.api.key.");
        }

        List<OMDB> movieList = new ArrayList<>();
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
                movieList.add(movieInfo);
            }
        }

        if (movieList.isEmpty()) {
            throw new RuntimeException("No movie movieList found for the provided titles.");
        }

        
        genreList = new ArrayList<>();
        for (OMDB movie : movieList) {
            if (movie.getGenre() != null && !movie.getGenre().isBlank()) {
                for (String genre : movie.getGenre().split(",")) {
                    genreList.add(genre.trim());
                }
            }
        }


        return movieList;
    }

    public String topGenre(List<OMDB> movieList){
        if(movieList==null){
            throw new RuntimeException("Movie's Genre is not given properly from the API");
        }
        genreList = new ArrayList<>(); // Store this call's genres in the service-level list.
        for(OMDB movies : movieList){
            for(String genres : movies.getGenre().split(",")){
                genreList.add(genres);
            }
        }
        HashMap<String , Integer> countGenre = new HashMap<>();
        for(String genre : genreList){
            if(countGenre.containsKey(genre)){
                countGenre.merge(genre , 1, Integer::sum);
            }
            else{
                countGenre.put(genre , 1);
            }
        }
        int min = Integer.MIN_VALUE;
        String topGenre = "";
        for(Map.Entry<String,Integer> genres : countGenre.entrySet()){
            if(genres.getValue() > min){
                topGenre = genres.getKey();
            }
        }
        return topGenre;
    }
}

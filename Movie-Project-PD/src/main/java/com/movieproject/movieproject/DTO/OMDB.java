package com.movieproject.movieproject.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OMDB {
    @JsonProperty("Title")
    private String movieName;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Response")
    private boolean response;

    public OMDB() {}

    public OMDB(String genre, String movieName, boolean response) {
        this.genre = genre;
        this.movieName = movieName;
        this.response = response;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}

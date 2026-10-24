package com.movieproject.movieproject.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OMDB {
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Response")
    private boolean response;

    public OMDB() {}

    public OMDB(String genre, String title, boolean response) {
        this.genre = genre;
        this.title = title;
        this.response = response;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


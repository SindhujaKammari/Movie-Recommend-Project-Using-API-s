package com.movieproject.movieproject.DTO;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;

@Embeddable 
public class userDto {
    private String userName;

    @ElementCollection 
    private List<String> movieList;


    public userDto(){
        this.movieList = new ArrayList<>();
    }

    public userDto(String userName, List<String> movieList){
        this.userName = userName ;
        this.movieList = (movieList!=null)? movieList: new ArrayList<>();
    }

    public String getUserName(){return userName;}
    public List<String> getMovieList(){return movieList;}

    public void setUserName(String userName){this.userName = userName;}
    public void setMovieList(List<String> movieList){this.movieList = movieList;}
}

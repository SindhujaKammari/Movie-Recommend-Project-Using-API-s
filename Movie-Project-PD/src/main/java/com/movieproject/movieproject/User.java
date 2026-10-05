package com.movieproject.movieproject;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @ElementCollection
    @CollectionTable(
            name = "user_movies",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "movie")
    private List<String> movieList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public User() {
    }

    public User(String userName, List<String> movieList) {
        this.userName = userName;

        if (movieList != null) {
            this.movieList = movieList;
        }
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getMovieList() {
        return movieList;
    }

    public Room getRoom() {
        return room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMovieList(List<String> movieList) {
        this.movieList = movieList;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
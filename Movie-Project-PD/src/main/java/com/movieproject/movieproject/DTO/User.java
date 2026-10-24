package com.movieproject.movieproject.DTO;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "movie_room")
public class User {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;

    @ManyToOne  
    @JoinColumn(name="roomId")
    private CreateRoom createRoom;

    @NotNull 
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition="json")
    private List<String> movieList;

    @NotNull(message="dont you have a name?")
    private String userName;


    public User() {
    }


    public User(CreateRoom createRoom, List<String> movieList, Long userId, String userName) {
        this.createRoom = createRoom;
        this.movieList = movieList;
        this.userId = userId;
        this.userName = userName;
    }

    public CreateRoom getCreateRoom() {
        return createRoom;
    }

    public void setCreateRoom(CreateRoom createRoom) {
        this.createRoom = createRoom;
    }

    public List<String> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<String> movieList) {
        this.movieList = movieList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
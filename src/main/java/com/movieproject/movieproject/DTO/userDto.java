package com.movieproject.movieproject.DTO;

import java.util.List;

public class UserDTO {
    public String roomId;
    public String userName;
    public List<String> movieList;

    public UserDTO(){}
    public UserDTO(String roomId, String userName, List<String> movieList) {
		this.roomId = roomId;
		this.userName = userName;
		this.movieList = movieList;
	}

    public String getRoomId() {
        return roomId;
    }
	public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<String> movieList) {
        this.movieList = movieList;
    }
}

package com.movieproject.movieproject.DTO;

//import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RoomDetails")
public class CreateRoom {
    @Id
    private String roomId;
    private Integer numOfUsers;

    public CreateRoom() {
    }

    public CreateRoom(String roomId, Integer numOfUsers) {
        this.roomId = roomId;
        this.numOfUsers = numOfUsers;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getNumOfUsers() {
        return numOfUsers;
    }

    public void setNumOfUsers(Integer numOfUsers) {
        this.numOfUsers = numOfUsers;
    }

}

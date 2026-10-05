package com.movieproject.movieproject;

import java.util.ArrayList;
import java.util.List;

import com.movieproject.movieproject.DTO.Leader;
import com.movieproject.movieproject.DTO.userDto;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="Room")
public class Room {
    
    @Id 
    @Column(name="roomId")
    public String roomId;

    @ElementCollection
    private List<userDto> users = new ArrayList<>();

    @Embedded 
    private Leader leader;

    public Room(){}

    public Room(Leader leader , String roomId){
        this.leader = leader;
        this.roomId = roomId;
    }

    public String getRoomId(){ return roomId;}
    public Leader getLeader(){ return leader;}
    public List<userDto> getUsers(){ return users;}

    public void setRoomId(String roomId){this.roomId = roomId;}
    public void setLeader(Leader leader){this.leader = leader;}
    public void setUsers(List<userDto> users){this.users = users;}

}

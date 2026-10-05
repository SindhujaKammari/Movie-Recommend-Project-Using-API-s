package com.movieproject.movieproject;

import java.util.ArrayList;
import java.util.List;

import com.movieproject.movieproject.DTO.Leader;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "room_id")
    private String roomId;

    @Embedded
    private Leader leader;

    @OneToMany(
            mappedBy = "room",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<User> users = new ArrayList<>();

    public Room() {
    }

    public Room(Leader leader, String roomId) {
        this.leader = leader;
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public Leader getLeader() {
        return leader;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
        user.setRoom(this);
    }

    public void removeUser(User user) {
        users.remove(user);
        user.setRoom(null);
    }
}
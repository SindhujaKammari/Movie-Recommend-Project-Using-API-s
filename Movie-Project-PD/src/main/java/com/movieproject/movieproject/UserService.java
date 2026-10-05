package com.movieproject.movieproject;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.movieproject.movieproject.DTO.Leader;
import com.movieproject.movieproject.DTO.userDto;
import com.movieproject.movieproject.JPA_Repos.RoomRepo;

@Service
public class UserService {

    private final RoomRepo roomRepo;

    public UserService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public String createID(String status, Leader leader) {

        if (!status.equalsIgnoreCase("leader")) {
            return null;
        }

        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        String generatedId;

        do {
            StringBuilder idBuilder = new StringBuilder();

            for (int i = 0; i < 6; i++) {
                int randomIndex =
                        new Random().nextInt(alphabets.length());

                idBuilder.append(alphabets.charAt(randomIndex));
            }

            generatedId = idBuilder.toString();

        } while (roomRepo.existsById(generatedId));

        leader.setId(generatedId);

        Room room = new Room(leader, generatedId);

        roomRepo.save(room);

        return generatedId;
    }

    public boolean checkId(String id) {

        if (id == null || id.isBlank()) {
            return false;
        }

        return roomRepo.existsById(id);
    }

    public User joinRoom(String roomId, userDto userChoice) {

        if (roomId == null || userChoice == null) {
            return null;
        }

        Room room = roomRepo.findById(roomId).orElse(null);

        if (room == null) {
            return null;
        }

        User user = new User(
                userChoice.getUserName(),
                userChoice.getMovieList()
        );

        room.addUser(user);

        roomRepo.save(room);

        return user;
    }

    public List<User> getUsers(String roomId) {

        Room room = roomRepo.findById(roomId).orElse(null);

        if (room == null) {
            return null;
        }

        return room.getUsers();
    }

    public Room getRoom(String roomId) {

        return roomRepo.findById(roomId).orElse(null);
    }
}
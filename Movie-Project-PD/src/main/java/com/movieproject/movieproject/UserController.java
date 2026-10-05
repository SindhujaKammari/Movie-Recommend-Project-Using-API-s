package com.movieproject.movieproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieproject.movieproject.DTO.Leader;
import com.movieproject.movieproject.DTO.userDto;

import jakarta.validation.Valid;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/leader/create")
    public ResponseEntity<?> leaderPage(
            @Valid @RequestBody Leader leader) {

        if (leader == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Leader data cannot be null");
        }

        String id = userService.createID("leader", leader);

        if (id == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Unable to create room");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(leader);
    }

    @PostMapping("/{id}/join")
    public ResponseEntity<?> userJoining(
            @PathVariable String id,
            @RequestBody userDto userData) {

        if (!userService.checkId(id)) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Wrong Room ID");
        }

        if (userData == null || userData.getUserName() == null
                || userData.getUserName().isBlank()) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Username is required");
        }

        User user = userService.joinRoom(id, userData);

        if (user == null) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Unable to join room");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoom(
            @PathVariable String id) {

        Room room = userService.getRoom(id);

        if (room == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Room not found");
        }

        return ResponseEntity.ok(room);
    }
}
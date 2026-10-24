package com.movieproject.movieproject.controller;
import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieproject.movieproject.DTO.CreateRoom;
import com.movieproject.movieproject.DTO.UserDTO;
import com.movieproject.movieproject.Service_files.OMDBService;
import com.movieproject.movieproject.Service_files.UserService;





@RestController
public class UserController {

    private final UserService userService;
    private final OMDBService omdbService;

    public UserController(UserService userService, OMDBService omdbService){
        this.userService = userService;
        this.omdbService = omdbService;
    }

    @PostMapping("/student/api")
    public ResponseEntity<?> random(){
        return ResponseEntity.ok("Successfully entered");
    }

    @PostMapping("/createRoom")
    public ResponseEntity<?> createRoom(@RequestBody CreateRoom createRoom){
        String newRoomId = userService.generateRoomId();
        createRoom.setRoomId(newRoomId);
        CreateRoom newData = userService.saveData(createRoom);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newData);
    }

    @PostMapping("/join/{roomId}")
    public ResponseEntity<?> verifyUsers(@PathVariable String roomId){
        if(roomId!=null){
            boolean verify = userService.verifyRoom(roomId);
            if(verify){
                return ResponseEntity.status(HttpStatus.ACCEPTED).location(URI.create("/join/verified")).body("Verified User!! PLease go to the new Page '/join/verified' ");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("WRONG ID");
    }

    @PostMapping("/join/verified")
    public ResponseEntity<?> joinUsers(@RequestBody UserDTO user){
        if(user != null){
            return ResponseEntity.ok(userService.joinRoom(user));
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("user data must be in JSON format!");
    }

    @GetMapping("/results")
    public ResponseEntity<?> getResults(@RequestBody UserDTO userDto){
        if(userDto != null){
            return ResponseEntity.ok(omdbService.getResults(userDto));
        }

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("user data must be in JSON format!");
    }
}

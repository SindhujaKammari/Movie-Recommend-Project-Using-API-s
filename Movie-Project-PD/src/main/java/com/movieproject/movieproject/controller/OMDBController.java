package com.movieproject.movieproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieproject.movieproject.DTO.OMDB;
import com.movieproject.movieproject.DTO.UserDTO;
import com.movieproject.movieproject.Service_files.OMDBService;

@RestController
public class OMDBController {
    private final OMDBService omdbService;
    private List<OMDB> movieInfo;

    public OMDBController(OMDBService omdbService) {
        this.omdbService = omdbService;
    }

    @PostMapping("/result")
    public ResponseEntity<?> getResults(@RequestBody UserDTO userDto) {
        if (userDto != null) {
            movieInfo = omdbService.movieData(userDto);
            return ResponseEntity.ok(movieInfo);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Data!");
    }

    @GetMapping("/topgenre")
    public ResponseEntity<?> topGenre(){
        return ResponseEntity.ok(omdbService.topGenre(movieInfo));
    }
}

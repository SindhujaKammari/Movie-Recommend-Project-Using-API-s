package com.movieproject.movieproject;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieproject.movieproject.DTO.Leader;





@RestController 
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService){this.userService = userService;}
    

    @PostMapping("/leader/create")
    public ResponseEntity<?> leaderPage(@RequestBody  Leader leader) {
        if(leader!=null){
            String id = userService.createID("leader");
            leader.setId(id);

            return ResponseEntity.ok(leader);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data Not Accepted!");   
    }
    @PostMapping("/{id}/join")
    public ResponseEntity<?> UserJoining(@PathVariable String id ,@RequestBody String entity) {
        boolean verified = userService.checkId(id);
        if(verified){
            
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Entered wrong Id or Wrong data type(Should enter Json data)");
    }
    
    
    
}


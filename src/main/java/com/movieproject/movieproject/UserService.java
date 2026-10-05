package com.movieproject.movieproject;
import org.springframework.stereotype.Service;

import com.movieproject.movieproject.DTO.userDto;
import com.movieproject.movieproject.JPA_Repos.roomRepo;

@Service 
public class UserService {
    private String Id;
    
    private final roomRepo roomRepo;
    private final Room room = new Room();
    public UserService(roomRepo roomRepo){this.roomRepo = roomRepo;}

    public boolean checkId(String id){
        return Id.equals(id);
    }

    public userDto MovieData(userDto userChoice){
        if(userChoice!=null){
            return userChoice;
        }
        return null;
    }

    public String createID(String status){
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String generatedId = "";
        for(int i =0 ; i<6 ; i++){
            int randomIndexFromAlphabets = (int)(Math.floor(Math.random()*(alphabets.length())));
            generatedId += ""+alphabets.charAt(randomIndexFromAlphabets);
        }
        room.setRoomId(generatedId);
        roomRepo.save(room);
        if(status.equalsIgnoreCase("leader")){
            Id = generatedId;
            return generatedId;
        }

        return "Id is not generated properly! please consider re-filling the status";
    }

}

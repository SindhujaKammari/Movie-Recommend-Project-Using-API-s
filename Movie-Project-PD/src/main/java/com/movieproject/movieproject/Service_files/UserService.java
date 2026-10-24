package com.movieproject.movieproject.Service_files;
import org.springframework.stereotype.Service;

import com.movieproject.movieproject.DTO.CreateRoom;
import com.movieproject.movieproject.DTO.User;
import com.movieproject.movieproject.DTO.UserDTO;
import com.movieproject.movieproject.JPA_Repos.RoomRepository;
import com.movieproject.movieproject.JPA_Repos.UserRepo;

@Service
public class UserService {
    private final RoomRepository roomRepo;
    private final UserRepo userRepo;

    public UserService(RoomRepository roomRepo , UserRepo userRepo){
        this.roomRepo = roomRepo ;
        this.userRepo = userRepo;
    }

    public String generateRoomId(){
        String generateId = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String resultId ="";
        for(int i=0;i<8;i++){
            int random = (int)(Math.random()*(generateId.length()));
            resultId += generateId.charAt(random);
        }
        return resultId;
    }

    public CreateRoom saveData(CreateRoom createRoom){
        return roomRepo.save(createRoom);
    }

    public boolean verifyRoom(String roomId){
        if(roomId != null && !roomId.isBlank()){
            return roomRepo.findById(roomId).isPresent();
        }
        return false;
    }

   public UserDTO joinRoom(UserDTO newUserDTO) {
        if (newUserDTO == null) {
            throw new RuntimeException("No data found!");
        }

        CreateRoom newRoom = roomRepo.findById(newUserDTO.getRoomId())
                .orElseThrow(() ->
                    new RuntimeException(
                        "Room does not exist: [" + newUserDTO.getRoomId() + "]"
                    )
                );

        User newUser = new User();
        newUser.setMovieList(newUserDTO.getMovieList());
        newUser.setUserName(newUserDTO.getUserName());
        newUser.setCreateRoom(newRoom);

        userRepo.save(newUser);
        return newUserDTO;
    }


}

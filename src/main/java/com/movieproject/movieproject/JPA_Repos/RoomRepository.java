package com.movieproject.movieproject.JPA_Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieproject.movieproject.DTO.CreateRoom;


public interface RoomRepository extends JpaRepository<CreateRoom, String> {
}

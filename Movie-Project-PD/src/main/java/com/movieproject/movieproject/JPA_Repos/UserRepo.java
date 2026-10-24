package com.movieproject.movieproject.JPA_Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieproject.movieproject.DTO.User;

public interface UserRepo extends JpaRepository<User, Long>{

}

package com.devops.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devops.DTO.UserDTO;

public interface UserDAO extends JpaRepository<UserDTO, Integer> {

}

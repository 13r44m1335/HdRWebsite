package com.example.taskr0676600.domain.service;

import com.example.taskr0676600.dto.CreateUserDTO;
import com.example.taskr0676600.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(CreateUserDTO userDTO);
    boolean userInDb(String username);
}

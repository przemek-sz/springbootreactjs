package com.server.service;

import com.server.dto.AllUserDto;
import com.server.dto.UserRegistrationDto;
import com.server.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public void addUser(UserRegistrationDto user);
    public void updateUser(User user);
    public void removeUser(User user);
    public List<AllUserDto> getAllUsers();
    public User getByusername(String username);
    public User getByid(Long id);
}

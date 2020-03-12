package com.server.service;

import com.server.dto.UserRegistrationDto;
import com.server.model.User;
import org.springframework.stereotype.Service;

@Service
public class DtoToUserConverter implements BaseConverter<UserRegistrationDto, User>{

    @Override
    public User convert(UserRegistrationDto from) {

        User user=new User();

        user.setUsername(from.getUsername());
        user.setEmail(from.getEmail());
        user.setPassword(from.getPassword());


        return user;
    }
}

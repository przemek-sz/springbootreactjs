package com.server.service;

import com.server.dto.AllUserDto;
import com.server.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserToDtoConverter implements BaseConverter<User, AllUserDto>{

    @Override
    public AllUserDto convert(User from) {

        AllUserDto userDto= new AllUserDto();
        userDto.setId(from.getId());
        userDto.setUsername(from.getUsername());
        userDto.setEmail(from.getEmail());

        return userDto;
    }


}

package com.server.service;

import com.server.dto.AllUserDto;
import com.server.dto.UserRegistrationDto;
import com.server.model.User;
import com.server.repository.UserRepository;
import com.server.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserRoleRepository userRoleRepository;
    BaseConverter<User, AllUserDto> baseConverter;
    BaseConverter<UserRegistrationDto,User> registrationBaseConverter;

    @Autowired
    UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, BaseConverter<User, AllUserDto> baseConverter, BaseConverter<UserRegistrationDto,User> registrationBaseConverter){
        this.userRepository=userRepository;
        this.userRoleRepository=userRoleRepository;
        this.baseConverter=baseConverter;
        this.registrationBaseConverter=registrationBaseConverter;
    }

    @Override
    public void addUser(UserRegistrationDto userDto) {

        String DEFAULT_ROLE="ROLE_USER";

        //User user=new User();

        User user=registrationBaseConverter.convert(userDto);
        user.getRoles().add(userRoleRepository.getByRole(DEFAULT_ROLE));

        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<AllUserDto> getAllUsers() {

        List<AllUserDto> usersDto=baseConverter.convertAll(userRepository.findAll());
        return usersDto;
    }

    @Override
    public User getByusername(String username) {
        return userRepository.getByusername(username);
    }

    @Override
    public User getByid(Long id) {
        return userRepository.getByid(id);
    }
}

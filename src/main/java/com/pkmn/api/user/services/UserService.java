package com.pkmn.api.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkmn.api.exceptions.UserServiceException;
import com.pkmn.api.exceptions.UtilsException;
import com.pkmn.api.user.dto.UserDto;
import com.pkmn.api.user.dto.UserIdDto;
import com.pkmn.api.user.entities.User;
import com.pkmn.api.user.repositories.UserRepository;
import com.pkmn.api.utils.Utils;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Transactional
    public UserDto insertUser(UserIdDto user){
        try {
            User userInsert = Utils.userDtoToUser(user);
            return new UserDto(repository.save(userInsert));
        } 
        catch (UtilsException e) {
            throw new UserServiceException("There was a problem converting a UserDto to a User!\nReason:" + e.getMessage());
        }
    }
}

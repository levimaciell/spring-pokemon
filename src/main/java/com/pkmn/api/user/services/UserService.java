package com.pkmn.api.user.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkmn.api.exceptions.UserServiceException;
import com.pkmn.api.exceptions.UtilsException;
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
    public UserIdDto insertUser(UserIdDto user){
        try {
            User userInsert = Utils.userDtoToUser(user);

            if(repository.findByUserName(user.getUserName()).isPresent())
                throw new UserServiceException("Cannot insert user. User name already exists");
            
            return new UserIdDto(repository.save(userInsert));
        } 
        catch (UtilsException e) {
            throw new UserServiceException("There was a problem converting a UserDto to a User!\nReason:" + e.getMessage());
        }
    }

    @Transactional
    public void deleteUser(UserIdDto user){
        if(!Utils.isUserValid(user)){
            throw new UserServiceException("User is not valid for deletion!");
        }
        repository.deleteByUserNameAndPassword(user.getUserName(), user.getPassword());
    }
}

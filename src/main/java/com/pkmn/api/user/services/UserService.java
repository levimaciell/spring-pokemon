package com.pkmn.api.user.services;


import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkmn.api.user.dto.UserIdDto;
import com.pkmn.api.user.dto.UserUpdateDto;
import com.pkmn.api.user.entities.User;
import com.pkmn.api.user.exceptions.UserCreationException;
import com.pkmn.api.user.exceptions.UserServiceException;
import com.pkmn.api.user.repositories.UserRepository;
import com.pkmn.api.utils.Utils;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Transactional
    public UserIdDto insertUser(UserIdDto user){
   
        User userInsert = userIdDtoToUser(user);

        if(repository.findByUserName(user.getUserName()).isPresent())
            throw new UserCreationException("User name is already taken!");
            
        return new UserIdDto(repository.save(userInsert));
        
    }

    @Transactional
    public void deleteUser(UserIdDto user){
        if(!Utils.isUserValid(user)){
            throw new UserServiceException("User is not valid for deletion!");
        }
        repository.deleteByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    @Transactional
    public void updateUser(UserUpdateDto user){

        try{
            
            //If username of change already exists, don't allow change
            if(repository.existsByUserName(user.getChangeUserName()))
                throw new UserServiceException(Errors.CHANGE_USERNAME_ALREADY_EXISTS.getError());

            User userUpdate = repository.getReferenceById(getIdByUserName(user));
            updateUserData(userUpdate, user);
            repository.save(userUpdate);
        }
        catch(UserServiceException u){
            throw u;
        }
        catch(NoSuchElementException e){
            throw new UserServiceException("The actualUsername does not exist, please inform a valid one!");
        }
    }

    private Long getIdByUserName(UserUpdateDto user){  
        Optional<User> userResult = repository.findByUserName(user.getActualUsername());
        return userResult.get().getId();
    }

    private void updateUserData(User user, UserUpdateDto userUpdateData){

        //If both are blank, throw exception
        if(userUpdateData.getChangeUserName().isBlank() && userUpdateData.getChangePassword().isBlank())
            throw new UserServiceException(Errors.CHANGE_USERNAME_BOTH_FIELDS_BLANK.getError());

        //If username is blank, but password is not
        if(userUpdateData.getChangeUserName().isBlank() && !userUpdateData.getChangePassword().isBlank()){
            user.setPassword(userUpdateData.getChangePassword());
        }
        //If username is not blank, but password is blank
        else if(!userUpdateData.getChangeUserName().isBlank() && userUpdateData.getChangePassword().isBlank()){
            user.setUserName(userUpdateData.getChangeUserName());
        }
        else{
            user.setUserName(userUpdateData.getChangeUserName());
            user.setPassword(userUpdateData.getChangePassword());
        }
    }

    public static User userIdDtoToUser(UserIdDto user){

        if(user == null){
            throw new UserCreationException("User Informed is null !");
        }
        else{
            if(user.getUserName().isBlank()){
                throw new UserCreationException("Username is blank! It's necessary to have a username!");
            }
            else if(user.getPassword().isBlank()){
                throw new UserCreationException("Password informed is blank! It's necessary to have a password");
            }
        }

        User userReturn = new User();
        userReturn.setPassword(user.getPassword());
        userReturn.setUserName(user.getUserName());

        return userReturn;
    }

    public enum Errors{

        CHANGE_USERNAME_ALREADY_EXISTS("The username for change is already taken. Please try again with another username!"),
        CHANGE_USERNAME_BOTH_FIELDS_BLANK("Both fields are blank. Only one can be blank so the other can be changed");

        private final String error;

        private Errors(String error){
            this.error = error;
        }

        public String getError(){
            return error;
        }
    }
}

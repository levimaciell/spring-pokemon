package com.pkmn.api.user.controllers;

import com.pkmn.api.user.dto.UserIdDto;
import com.pkmn.api.user.dto.UserUpdateDto;
import com.pkmn.api.user.exceptions.UserServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkmn.api.user.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> insertUser(@RequestBody UserIdDto user){

        service.insertUser(user);
        return new ResponseEntity<String>("User Created sucessfully!", HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<UserIdDto> deleteUser(@RequestBody UserIdDto user){
        service.deleteUser(user);
        return ResponseEntity.accepted().body(user);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserUpdateDto user){
        try{
            service.updateUser(user);
            return new ResponseEntity<String>("User Updated Succesfully", HttpStatus.OK);
        }
        catch(UserServiceException e){
            return new ResponseEntity<String>("User not updated. \nReason: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

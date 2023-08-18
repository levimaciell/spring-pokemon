package com.pkmn.api.user.controllers;

import com.pkmn.api.exceptions.UserServiceException;
import com.pkmn.api.user.dto.UserIdDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        try{
            service.insertUser(user);
            return new ResponseEntity<String>("User Created sucessfully!", HttpStatus.CREATED);
        }
        catch (UserServiceException e){
            return new ResponseEntity<String>("There is already a user with this name", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping
    public ResponseEntity<UserIdDto> deleteUser(@RequestBody UserIdDto user){
        try{
            service.deleteUser(user);
            return ResponseEntity.accepted().body(user);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}

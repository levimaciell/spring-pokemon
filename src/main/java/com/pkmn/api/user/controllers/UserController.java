package com.pkmn.api.user.controllers;

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
    public ResponseEntity<UserIdDto> insertUser(@RequestBody UserIdDto user){
        return new ResponseEntity<UserIdDto>(service.insertUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<UserIdDto> deleteUser(@RequestBody UserIdDto user){
        return ResponseEntity.accepted().body(user);
    }

}

package com.pkmn.api.user.controllers;

import com.pkmn.api.response.ApiResponse;
import com.pkmn.api.user.dto.UserIdDto;
import com.pkmn.api.user.dto.UserUpdateDto;

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
    public ResponseEntity<ApiResponse> insertUser(@RequestBody UserIdDto user){

        service.insertUser(user);
        
        ApiResponse response = new ApiResponse(HttpStatus.CREATED, "User created sucessfully!");
        return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteUser(@RequestBody UserIdDto user){
        service.deleteUser(user);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserUpdateDto user){

        service.updateUser(user);
        return ResponseEntity.noContent().build();
    }
}

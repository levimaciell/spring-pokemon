package com.pkmn.api.user.controllers;

import java.util.List;
import com.pkmn.api.user.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkmn.api.user.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDto> findAllUsers(){
        return service.findAll();
    }

}

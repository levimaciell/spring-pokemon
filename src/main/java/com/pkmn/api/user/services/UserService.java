package com.pkmn.api.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkmn.api.user.dto.UserDto;
import com.pkmn.api.user.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<UserDto> findAll(){
        return repository.findAll().stream().map(x -> new UserDto(x)).toList();
    }

}

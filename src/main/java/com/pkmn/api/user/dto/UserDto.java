package com.pkmn.api.user.dto;

import com.pkmn.api.user.entities.User;

public class UserDto {
    
    private Long id;
    private String userName;
    private String password;

    
    public UserDto() {
    }

    public UserDto(User user) {
        id = user.getId();
        userName = user.getUserName();
        password = user.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}

package com.pkmn.api.user.dto;

import com.pkmn.api.user.entities.User;

public class UserIdDto {
    
    private String userName;
    private String password;
    
    public UserIdDto() {
    }

    public UserIdDto(User user) {
        userName = user.getUserName();
        password = user.getPassword();
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    
}

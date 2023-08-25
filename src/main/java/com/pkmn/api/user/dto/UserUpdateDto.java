package com.pkmn.api.user.dto;

public class UserUpdateDto {
    private String actualUsername;
    private String actualPassword;
    private String changeUserName;
    private String changePassword;
    
    public UserUpdateDto() {
    }

    public String getActualUsername() {
        return actualUsername;
    }

    public String getChangeUserName() {
        return changeUserName;
    }

    public String getChangePassword() {
        return changePassword;
    }

    public String getActualPassword(){
        return actualPassword;
    }
    
}

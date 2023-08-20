package com.pkmn.api.user.exceptions;

public class UserCreationException extends RuntimeException{
    public UserCreationException(String msg){
        super(msg);
    }
}

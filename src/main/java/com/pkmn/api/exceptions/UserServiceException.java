package com.pkmn.api.exceptions;

public class UserServiceException extends RuntimeException {
    
    public UserServiceException(String msg){
        super(msg);
    }

}

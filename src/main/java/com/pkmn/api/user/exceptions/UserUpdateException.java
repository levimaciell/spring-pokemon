package com.pkmn.api.user.exceptions;

import org.springframework.http.HttpStatus;

public class UserUpdateException extends RuntimeException{
    
    private HttpStatus httpCode;

    public UserUpdateException(String msg, HttpStatus httpCode){
        super(msg);
        this.httpCode = httpCode;
    }

    public HttpStatus getHttpCode(){
        return httpCode;
    }
}

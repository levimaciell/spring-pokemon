package com.pkmn.api.user.exceptions;

import org.springframework.http.HttpStatus;

public class UserDeletionException extends RuntimeException{

    private HttpStatus httpCode;

    public UserDeletionException(String msg, HttpStatus httpCode){
        super(msg);
        this.httpCode = httpCode;
    }
    
    public HttpStatus getHttpCode(){
        return httpCode;
    }
}

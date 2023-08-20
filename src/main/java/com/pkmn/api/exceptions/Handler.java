package com.pkmn.api.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pkmn.api.pokemon.exceptions.PokemonNotfoundException;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> genericError(Exception exception){
        ApiResponse response = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception, List.of(exception.getMessage()));

        return new ResponseEntity<ApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PokemonNotfoundException.class)
    public ResponseEntity<ApiResponse> pokemonNotFoundError(PokemonNotfoundException exception){
        ApiResponse response = new ApiResponse(HttpStatus.NOT_FOUND, exception, List.of(exception.getMessage()));
        
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }
    
}

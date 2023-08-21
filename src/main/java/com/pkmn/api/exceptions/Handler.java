package com.pkmn.api.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pkmn.api.pokemon.exceptions.PokemonNotfoundException;
import com.pkmn.api.user.exceptions.UserCreationException;
import com.pkmn.api.user.exceptions.UserDeletionException;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseError> genericError(Exception exception){
        ApiResponseError response = new ApiResponseError(HttpStatus.INTERNAL_SERVER_ERROR, List.of("There was a internal server error"));

        return new ResponseEntity<ApiResponseError>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PokemonNotfoundException.class)
    public ResponseEntity<ApiResponseError> pokemonNotFoundError(PokemonNotfoundException exception){
        ApiResponseError response = new ApiResponseError(HttpStatus.NOT_FOUND, List.of(exception.getMessage()));

        return new ResponseEntity<ApiResponseError>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserCreationException.class)
    public ResponseEntity<ApiResponseError> userCreationFail(UserCreationException exception){

        List<String> errors = List.of("It was not possible to insert a user. Please try again"
        , "Reason: " + exception.getMessage());

        ApiResponseError response = new ApiResponseError(HttpStatus.BAD_REQUEST, errors);

        return new ResponseEntity<ApiResponseError>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserDeletionException.class)
    public ResponseEntity<ApiResponseError> userDeletionError(UserDeletionException exception){
        ApiResponseError response = new ApiResponseError(exception.getHttpCode(), List.of(
            "It was not possible to delete the user", "Reason: " + exception.getMessage()));

        return new ResponseEntity<ApiResponseError>(response, exception.getHttpCode());
    }

}

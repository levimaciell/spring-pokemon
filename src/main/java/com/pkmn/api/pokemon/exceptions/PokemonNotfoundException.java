package com.pkmn.api.pokemon.exceptions;

public class PokemonNotfoundException extends RuntimeException{
    public PokemonNotfoundException(String msg){
        super(msg);
    }
}

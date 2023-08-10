package com.pkmn.api.pokemon.dto;

import com.pkmn.api.pokemon.entities.Pokemon;

public class PokemonMinDto {
    
    private int pokedexEntry;
    private String name;
    private String type1;
    private String type2;
    
    public PokemonMinDto() {
    }

    public PokemonMinDto(Pokemon pokemon) {
        pokedexEntry = pokemon.getPokedexEntry();
        name = pokemon.getName();
        type1 = pokemon.getType1();
        type2 = pokemon.getType2();
    }

    public int getPokedexEntry() {
        return pokedexEntry;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    

}

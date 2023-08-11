package com.pkmn.api.pokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkmn.api.Utils.Utils;
import com.pkmn.api.pokemon.dto.PokemonMaxDto;
import com.pkmn.api.pokemon.dto.PokemonMinDto;
import com.pkmn.api.pokemon.entities.Pokemon;
import com.pkmn.api.pokemon.repositories.PokemonRepository;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository repo;

    public List<PokemonMinDto> findAll(){
        return repo.findAll().stream().map(PokemonMinDto::new).toList();
    }

    public PokemonMaxDto findByPokedexEntry(Integer pokedexEntry){

        Pokemon searchResult = repo.findByPokedexEntry(pokedexEntry);

        if(searchResult != null){
            PokemonMaxDto pokemonDto = new PokemonMaxDto(searchResult);
            return pokemonDto;
        }

        //For now, return an empty Dto just to not break anything
        return new PokemonMaxDto();
    }

    public PokemonMaxDto findByName(String name){

        String searchString = Utils.capitalizeString(name);

        Pokemon searchResult = repo.findByName(searchString);
        
        if(searchResult != null){
            return new PokemonMaxDto(searchResult);
        }

        return new PokemonMaxDto();
    }

}

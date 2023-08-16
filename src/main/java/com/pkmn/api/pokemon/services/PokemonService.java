package com.pkmn.api.pokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkmn.api.pokemon.dto.PokemonMaxDto;
import com.pkmn.api.pokemon.dto.PokemonMinDto;
import com.pkmn.api.pokemon.entities.Pokemon;
import com.pkmn.api.pokemon.exceptions.PokemonNotfoundException;
import com.pkmn.api.pokemon.repositories.PokemonRepository;
import com.pkmn.api.utils.Utils;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository repo;

    public List<PokemonMinDto> findAll(){
        return repo.findAll().stream().map(PokemonMinDto::new).toList();
    }

    public PokemonMaxDto findByPokedexEntry(Integer pokedexEntry) throws PokemonNotfoundException{

        Pokemon searchResult = repo.findByPokedexEntry(pokedexEntry);

        if(searchResult != null){
            PokemonMaxDto pokemonDto = new PokemonMaxDto(searchResult);
            return pokemonDto;
        }
        else{
            throw new PokemonNotfoundException("Pokemon with pokedex entry " + pokedexEntry + " was not found");
        }
        
    }

    public PokemonMaxDto findByName(String name) throws PokemonNotfoundException{

        Pokemon searchResult = repo.findByName(Utils.capitalizeString(name));
        
        if(searchResult != null){
            return new PokemonMaxDto(searchResult);
        }
        else{
            throw new PokemonNotfoundException("Pokemon with name " + name + " was not found");
        }
        
    }

}

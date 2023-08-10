package com.pkmn.api.pokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkmn.api.pokemon.entities.Pokemon;
import com.pkmn.api.pokemon.repositories.PokemonRepository;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository repo;

    public List<Pokemon> findAll(){
        return repo.findAll();
    }

    public Pokemon findByPokedexEntry(Integer pokedexEntry){
        Pokemon foundPkmn = repo.findByPokedexEntry(pokedexEntry);
        return foundPkmn;
    }

}

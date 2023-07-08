package com.pkmn.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkmn.api.entities.Pokemon;
import com.pkmn.api.repositories.PokemonRepository;

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

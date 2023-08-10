package com.pkmn.api.pokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkmn.api.pokemon.dto.PokemonMaxDto;
import com.pkmn.api.pokemon.dto.PokemonMinDto;
import com.pkmn.api.pokemon.repositories.PokemonRepository;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository repo;

    public List<PokemonMinDto> findAll(){
        return repo.findAll().stream().map(PokemonMinDto::new).toList();
    }

    public PokemonMaxDto findByPokedexEntry(Integer pokedexEntry){
        PokemonMaxDto foundPkmn = new PokemonMaxDto(repo.findByPokedexEntry(pokedexEntry));
        return foundPkmn;
    }

}

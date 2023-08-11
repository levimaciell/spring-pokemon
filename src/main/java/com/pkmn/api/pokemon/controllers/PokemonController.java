package com.pkmn.api.pokemon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkmn.api.Utils.Utils;
import com.pkmn.api.pokemon.dto.PokemonMaxDto;
import com.pkmn.api.pokemon.dto.PokemonMinDto;
import com.pkmn.api.pokemon.services.PokemonService;

@RestController
@RequestMapping(value = "/pokemons")
public class PokemonController {
    
    @Autowired
    private PokemonService pkmnService;

    @GetMapping
    public ResponseEntity<List<PokemonMinDto>> findAll(){
        List<PokemonMinDto> list = pkmnService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/entry/{pokedexEntry}")
    public ResponseEntity<PokemonMaxDto> findByPokedexEntry(@PathVariable Integer pokedexEntry){
        PokemonMaxDto pkmn = pkmnService.findByPokedexEntry(pokedexEntry);
        return ResponseEntity.ok().body(pkmn);
    }

    @GetMapping(value = "/pokemon-name/{pokemonName}")
    public ResponseEntity<PokemonMaxDto> findByPokemonName(@PathVariable String pokemonName){
        
        PokemonMaxDto pkmn = pkmnService.findByName(pokemonName);

        return ResponseEntity.ok().body(pkmn);
        
    }

}

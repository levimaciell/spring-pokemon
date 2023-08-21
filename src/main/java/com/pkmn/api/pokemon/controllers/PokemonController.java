package com.pkmn.api.pokemon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkmn.api.pokemon.dto.PokemonMaxDto;
import com.pkmn.api.pokemon.dto.PokemonMinDto;
import com.pkmn.api.pokemon.services.PokemonService;
import com.pkmn.api.response.ApiResponse;

@RestController
@RequestMapping(value = "/pokemons")
public class PokemonController {
    
    @Autowired
    private PokemonService pkmnService;

    @GetMapping(value = "/search/all")
    public ResponseEntity<ApiResponse> findAll(){
        List<PokemonMinDto> list = pkmnService.findAll();
        ApiResponse response = new ApiResponse(HttpStatus.OK, list);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/search/entry/{pokedexEntry}")
    public ResponseEntity<ApiResponse> findByPokedexEntry(@PathVariable Integer pokedexEntry){
        PokemonMaxDto pkmn = pkmnService.findByPokedexEntry(pokedexEntry);

        ApiResponse response = new ApiResponse(HttpStatus.OK, pkmn);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/search/pokemon-name/{pokemonName}")
    public ResponseEntity<ApiResponse> findByPokemonName(@PathVariable String pokemonName){

        PokemonMaxDto pkmn = pkmnService.findByName(pokemonName);

        ApiResponse response = new ApiResponse(HttpStatus.OK, pkmn);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }

}

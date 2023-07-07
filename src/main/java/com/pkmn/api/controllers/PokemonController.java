package com.pkmn.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkmn.api.entities.Pokemon;
import com.pkmn.api.services.PokemonService;

@RestController
@RequestMapping(value = "/pokemons")
public class PokemonController {
    
    @Autowired
    private PokemonService pkmnService;

    @GetMapping
    public ResponseEntity<List<Pokemon>> findAll(){
        List<Pokemon> list = pkmnService.findAll();
        return ResponseEntity.ok().body(list);
    }


}

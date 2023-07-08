package com.pkmn.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkmn.api.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer>{
    
    Pokemon findByPokedexEntry(int pokedexEntry);
}

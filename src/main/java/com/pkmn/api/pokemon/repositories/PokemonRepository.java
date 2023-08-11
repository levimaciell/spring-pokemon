package com.pkmn.api.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkmn.api.pokemon.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer>{
    
    Pokemon findByPokedexEntry(int pokedexEntry);

    Pokemon findByName(String name);
}

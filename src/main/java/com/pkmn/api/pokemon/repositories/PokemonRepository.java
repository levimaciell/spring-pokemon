package com.pkmn.api.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pkmn.api.pokemon.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer>{
    
    Pokemon findByPokedexEntry(int pokedexEntry);

    @Query(value = "SELECT * FROM POKEMONS WHERE NAME = :name", nativeQuery = true)
    Pokemon findByName(String name);
}

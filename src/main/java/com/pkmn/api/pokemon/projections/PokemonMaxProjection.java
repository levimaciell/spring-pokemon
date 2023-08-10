package com.pkmn.api.pokemon.projections;

public interface PokemonMaxProjection {
    int getPokedexEntry();
    String getName();
    String getType1();
    String getType2();
    int getTotal();
    int getHp();
    int getAttack();
    int getDefense();
    int getSpAttack();
    int getSpDefense();
    int getSpeed();
    int getGeneration();
    boolean getLegendary();
}

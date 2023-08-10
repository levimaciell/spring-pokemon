package com.pkmn.api.pokemon.dto;

import org.springframework.beans.BeanUtils;

import com.pkmn.api.pokemon.entities.Pokemon;
import com.pkmn.api.pokemon.projections.PokemonMaxProjection;

public class PokemonMaxDto {

    private int pokedexEntry;
    private String name;
    private String type1;
    private String type2;
    private int total;
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private int generation;
    private boolean legendary;

    public PokemonMaxDto() {
    }

    public PokemonMaxDto(Pokemon pokemon) {
        BeanUtils.copyProperties(pokemon, this);
    }

    public PokemonMaxDto(PokemonMaxProjection projection){
        pokedexEntry = projection.getPokedexEntry();
        name = projection.getName();
        type1 = projection.getType1();
        type2 = projection.getType2();
        total = projection.getTotal();
        hp = projection.getHp();
        attack = projection.getAttack();
        defense = projection.getDefense();
        spAttack = projection.getSpAttack();
        spDefense = projection.getSpDefense();
        speed = projection.getSpeed();
        generation = projection.getGeneration();
        legendary = projection.getLegendary();
    }

    public int getPokedexEntry() {
        return pokedexEntry;
    }

    public void setPokedexEntry(int pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public boolean isLegendary() {
        return legendary;
    }

    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }

    

}

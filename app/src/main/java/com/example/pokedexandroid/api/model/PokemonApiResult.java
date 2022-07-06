package com.example.pokedexandroid.api.model;

import java.util.List;


public class PokemonApiResult {
    public int id;

    public String name;
    public List<PokemonTypeSlot> types;


    public PokemonApiResult(int id, String name, List<PokemonTypeSlot> types) {
        this.name = name;
        this.types = types;
        this.id = id;
    }
}

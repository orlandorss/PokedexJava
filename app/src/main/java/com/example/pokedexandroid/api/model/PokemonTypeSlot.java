package com.example.pokedexandroid.api.model;

import com.example.pokedexandroid.domain.PokemonType;

public class PokemonTypeSlot {
    public int slot;
    public final PokemonType type;
    public String name;

    public PokemonTypeSlot(int slot, PokemonType type) {
        this.slot = slot;
        this.type = type;
    }

}

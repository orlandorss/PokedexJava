package com.example.pokedexandroid.api.model;

import java.util.List;

public class PokemonsApiResult {

    public int count;
    public String next;
    public String previous;
    public List<PokemonResult> results;

    public PokemonsApiResult(int count, String next, String previous, List<PokemonResult> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }
}


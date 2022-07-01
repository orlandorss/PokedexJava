package com.example.pokedexandroid.domain;

import java.util.List;

public class Pokemon {
    public String imgUrl;
    public int number;
    public String name;
    public List<PokemonType> types;
    public String formatedNumber;

    public Pokemon(String imgUrl, int number, String name, List<PokemonType> types) {
        this.imgUrl = imgUrl;
        this.number = number;
        this.name = name;
        this.types = types;
        this.formatedNumber = String.format("%03d", number);
    }


}



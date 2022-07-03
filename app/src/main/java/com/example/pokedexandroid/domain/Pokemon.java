package com.example.pokedexandroid.domain;

import com.example.pokedexandroid.api.model.PokemonResult;

import java.util.List;

public class Pokemon extends PokemonResult {

    public int number;
    public String name;
    public List<PokemonType> types;
    public String formatedNumber;
    public String formatedName;
    public String formatedType1;
    public String formatedType2;

    public String imgUrl;

    public Pokemon(int number, String name, List<PokemonType> types) {
        this.number = number;
        this.name = name;
        this.types = types;
        this.formatedNumber = String.format("%03d", number);
        this.formatedName = name.substring(0, 1).toUpperCase() + name.substring(1);
        this.formatedType1 = types.get(0).name.substring(0, 1).toUpperCase() + types.get(0).name.substring(1);
        this.imgUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/" + formatedNumber + ".png";
    }




}



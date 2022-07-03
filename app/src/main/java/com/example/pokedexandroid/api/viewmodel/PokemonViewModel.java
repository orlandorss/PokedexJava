package com.example.pokedexandroid.api.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pokedexandroid.api.PokemonRepository;
import com.example.pokedexandroid.api.model.PokemonApiResult;
import com.example.pokedexandroid.api.model.PokemonsApiResult;
import com.example.pokedexandroid.domain.Pokemon;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public final class PokemonViewModel extends ViewModel {
    public MutableLiveData pokemons = new MutableLiveData<List<Pokemon>>();

    public PokemonViewModel() {
        new Thread(this::loadPokemons).

                start();
    }

    private void loadPokemons() {
        try {
            PokemonsApiResult pokemonsApiResult = PokemonRepository.listPokemons(151);

            assert pokemonsApiResult.results != null;
            pokemons.postValue(pokemonsApiResult.results.stream().map(pokemonResult -> {
                int number;
                number = Integer.parseInt(pokemonResult.url
                        .replace("https://pokeapi.co/api/v2/pokemon/", "")
                        .replace("/", ""));

                PokemonApiResult pokemonApiResult;
                pokemonApiResult = PokemonRepository.getPokemons(number);

                assert pokemonApiResult != null;
                return new Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.stream().map(type -> type.type).collect(Collectors.toList())
                );
            }).collect(Collectors.toList()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

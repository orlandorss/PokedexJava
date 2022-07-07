package com.example.pokedexandroid.api;

import com.example.pokedexandroid.api.model.PokemonApiResult;
import com.example.pokedexandroid.api.model.PokemonsApiResult;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PokemonRepository {
    private static final PokemonService service;


    static {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PokemonService.class);
    }


    public static PokemonsApiResult listPokemons(int limit) throws IOException {

        Call<PokemonsApiResult> call;
        call = service.listPokemons(limit);

        return call.execute().body();
    }

    public static PokemonApiResult getPokemons(int number) {

        Call<PokemonApiResult> call;
        call = service.getPokemons(number);

        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}


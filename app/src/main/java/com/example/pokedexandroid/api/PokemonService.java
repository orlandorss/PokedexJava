package com.example.pokedexandroid.api;

import com.example.pokedexandroid.api.model.PokemonApiResult;
import com.example.pokedexandroid.api.model.PokemonsApiResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonService {

    @GET("pokemon")
    Call<PokemonsApiResult> listPokemons(@Query("limit") int limit);

    @GET("pokemon/{number}")
    Call<PokemonApiResult> getPokemons(@Path("number") int number);

}

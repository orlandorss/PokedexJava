package com.example.pokedexandroid.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedexandroid.R;
import com.example.pokedexandroid.api.PokemonRepository;
import com.example.pokedexandroid.api.model.PokemonApiResult;
import com.example.pokedexandroid.api.model.PokemonResult;
import com.example.pokedexandroid.api.model.PokemonsApiResult;
import com.example.pokedexandroid.domain.Pokemon;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvPokemons);

        new Thread(this::loadPokemons).start();
    }

    public void loadPokemons() {

        try {
            PokemonsApiResult pokemonsApiResult = PokemonRepository.listPokemons(151);

            assert pokemonsApiResult != null;
            for (PokemonResult result : pokemonsApiResult.results) {

                List<Pokemon> pokemons = pokemonsApiResult.results.stream().map(pokemonResult -> {

                    int number;
                    PokemonApiResult pokemonApiResult;
                    number = Integer.parseInt(pokemonResult.url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", ""));
                    pokemonApiResult = PokemonRepository.getPokemons(number);
                    assert pokemonApiResult != null;
                    return new Pokemon(
                            pokemonApiResult.id,
                            pokemonApiResult.name,
                            pokemonApiResult.types.stream().map(type -> type.type).collect(Collectors.toList())
                    );
                }).collect(Collectors.toList());


                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                recyclerView.post(() -> {
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(new PokemonAdapter(pokemons));
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


package com.example.pokedexandroid.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedexandroid.R;
import com.example.pokedexandroid.domain.Pokemon;
import com.example.pokedexandroid.domain.PokemonType;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvPokemons);

        Pokemon Ratata = new Pokemon("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/019.png", 19, "Ratata", List.of(new PokemonType("Normal")));
        List<Pokemon> pokemons = List.of(Ratata, Ratata, Ratata
        );


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PokemonAdapter(pokemons));
    }
}
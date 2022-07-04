package com.example.pokedexandroid.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedexandroid.R;
import com.example.pokedexandroid.api.viewmodel.PokemonViewModel;
import com.example.pokedexandroid.api.viewmodel.PokemonViewModelFactor;
import com.example.pokedexandroid.domain.Pokemon;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PokemonViewModel viewModel;

    //REFERENTE AO BY LAZY DO KOTLIN
    public synchronized PokemonViewModel lifeCycleViewModel() {
        if (viewModel == null) {
            viewModel = new ViewModelProvider(this, new PokemonViewModelFactor()).get(PokemonViewModel.class);
        }
        return viewModel;
    }

    //REFERENTE AO BY LAZY DO KOTLIN
    public synchronized RecyclerView lifeCycleRecyclerView() {
        if (recyclerView == null) {
            recyclerView = findViewById(R.id.rvPokemons);
        }
        return recyclerView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lifeCycleRecyclerView();

        lifeCycleViewModel().pokemons.observe(this, Observer -> {
                    loadRecyclerView();
                }
        );
    }

    private void loadRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PokemonAdapter((List<Pokemon>) viewModel.pokemons.getValue()));
    }
}


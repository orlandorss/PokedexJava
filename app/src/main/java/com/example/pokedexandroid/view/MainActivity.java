package com.example.pokedexandroid.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedexandroid.R;
import com.example.pokedexandroid.api.viewmodel.PokemonViewModel;
import com.example.pokedexandroid.api.viewmodel.PokemonViewModelFactor;
import com.example.pokedexandroid.domain.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PokemonViewModel viewModel;

    private SearchView searchView;
    private String selectedFilter = "all";
    private String currentSearchText = "";
    public static ArrayList<Pokemon> shapeList = new ArrayList<Pokemon>();


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
        initSearchWidgets();
    }

    private void initSearchWidgets() {
        searchView = (SearchView) findViewById(R.id.search_bar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                currentSearchText = s;
                ArrayList<Pokemon> filteredShapes = new ArrayList<Pokemon>();

                for (Pokemon pokemon : Objects.requireNonNull(viewModel.pokemons.getValue())) {
                    if (pokemon.name.toLowerCase().contains(s.toLowerCase())) {

                        filteredShapes.add(pokemon);
                    }
                }
                if (filteredShapes.isEmpty()) {
                    Toast.makeText(MainActivity.this, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
                } else {
                    PokemonAdapter adapter = new PokemonAdapter(filteredShapes);
                    recyclerView.setAdapter(adapter);
                }

                return false;
            }
        });
    }

    private void loadRecyclerView() {


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PokemonAdapter((List<Pokemon>) viewModel.pokemons.getValue()));


    }
}



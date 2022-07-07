package com.example.pokedexandroid.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.example.pokedexandroid.domain.PokemonOnclick;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PokemonViewModel viewModel;
    private PokemonAdapter.RecyclerViewClickListener listener;
    public PokemonViewModel items;


    //REFERENTE AO BY LAZY DO KOTLIN
    public synchronized PokemonViewModel lifeCycleViewModel() {
        if (viewModel == null) {
            viewModel = new ViewModelProvider(this, new PokemonViewModelFactor()).get(PokemonViewModel.class);
        }
        return viewModel;
    }

    //REFERENTE AO BY LAZY DO KOTLIN
    public synchronized void lifeCycleRecyclerView() {
        if (recyclerView == null) {
            recyclerView = findViewById(R.id.rvPokemons);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lifeCycleViewModel().pokemons.observe(this, Observer -> loadRecyclerView()
        );
        setContentView(R.layout.activity_main);
        lifeCycleRecyclerView();
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Pokemon> filteredShapes = new ArrayList<>();

                for (Pokemon pokemon : Objects.requireNonNull(viewModel.pokemons.getValue())) {
                    if (pokemon.name.toLowerCase().contains(s.toLowerCase())) {

                        filteredShapes.add(pokemon);
                    }
                }
                if (filteredShapes.isEmpty()) {
                    Toast.makeText(MainActivity.this, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
                } else {
                    PokemonAdapter adapter = new PokemonAdapter(filteredShapes, listener);
                    recyclerView.setAdapter(adapter);
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    private void loadRecyclerView() {
        setOnClickListener();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PokemonAdapter(viewModel.pokemons.getValue(), listener));
    }

    private void setOnClickListener() {
        listener = new PokemonAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), PokemonOnclick.class);
                intent.putExtra("name", viewModel.pokemons.getValue().get(position).formatedName);
                intent.putExtra("number", viewModel.pokemons.getValue().get(position).formatedNumber);
                intent.putExtra("img", viewModel.pokemons.getValue().get(position).imgUrl);
                startActivity(intent);
            }
        };
    }
}



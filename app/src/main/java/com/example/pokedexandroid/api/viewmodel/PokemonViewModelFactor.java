package com.example.pokedexandroid.api.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class PokemonViewModelFactor implements ViewModelProvider.Factory {


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PokemonViewModel();
    }
}

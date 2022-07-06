package com.example.pokedexandroid.view;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokedexandroid.R;
import com.example.pokedexandroid.domain.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {
    public List<Pokemon> items;


    public PokemonAdapter(List<Pokemon> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon item = items.get(position);
        holder.bindView(item);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public void bindView(Pokemon item) {

            ImageView ivPokemon = itemView.findViewById(R.id.ivPokemon);
            TextView tvNumber = itemView.findViewById(R.id.tvNumber);
            TextView tvName = itemView.findViewById(R.id.tvName);
            Button tvType1 = itemView.findViewById(R.id.tvType1);
            Button tvType2 = itemView.findViewById(R.id.tvType2);

            // content = ViewHolder.this.itemView.getContext()


            if (item != null) {
                Glide.with(itemView.getContext()).load(item.imgUrl).into(ivPokemon);
                tvNumber.setText("#" + item.formatedNumber);
                tvName.setText(item.formatedName);
                tvType1.setText(item.formatedType1);
                //TODO: CRIAR METODO PARA COR
                setPokemonsColor1(item, tvType1, tvType2, ivPokemon);

            }
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }


    private static void setPokemonsColor1(Pokemon item, Button tvType1, Button tvType2, ImageView ivPokemon) {

        switch (item.formatedType1) {
            case "Grass":
                tvType1.setBackgroundResource(R.drawable.grass);
                tvType1.setTextColor(Color.BLACK);
                ivPokemon.setBackgroundResource(R.drawable.grass);

                break;
            case "Poison":
                tvType1.setBackgroundResource(R.drawable.poison);
                ivPokemon.setBackgroundResource(R.drawable.poison);
                tvType1.setTextColor(Color.WHITE);
                break;
            case "Flying":
                tvType1.setBackgroundResource(R.drawable.flying);
                ivPokemon.setBackgroundResource(R.drawable.flying);
                tvType1.setTextColor(Color.BLACK);
                break;
            case "Fire":
                tvType1.setBackgroundResource(R.drawable.fire);
                ivPokemon.setBackgroundResource(R.drawable.fire);
                tvType1.setTextColor(Color.WHITE);
                break;
            case "Bug":
                tvType1.setBackgroundResource(R.drawable.bug);
                ivPokemon.setBackgroundResource(R.drawable.bug);
                tvType1.setTextColor(Color.WHITE);
                break;
            case "Water":
                tvType1.setBackgroundResource(R.drawable.water);
                ivPokemon.setBackgroundResource(R.drawable.water);
                tvType1.setTextColor(Color.WHITE);
                break;
            case "Normal":
                tvType1.setBackgroundResource(R.drawable.normal);
                ivPokemon.setBackgroundResource(R.drawable.normal);
                tvType1.setTextColor(Color.BLACK);
                break;
            case "Electric":
                tvType1.setBackgroundResource(R.drawable.electric);
                ivPokemon.setBackgroundResource(R.drawable.electric);
                tvType1.setTextColor(Color.BLACK);
                break;
            case "Ground":
                tvType1.setBackgroundResource(R.drawable.ground);
                ivPokemon.setBackgroundResource(R.drawable.ground);
                tvType1.setTextColor(Color.BLACK);
                break;
            case "Fairy":
                tvType1.setBackgroundResource(R.drawable.fairy);
                ivPokemon.setBackgroundResource(R.drawable.fairy);
                tvType1.setTextColor(Color.BLACK);
                break;
            case "Psychic":
                tvType1.setBackgroundResource(R.drawable.psychic);
                ivPokemon.setBackgroundResource(R.drawable.psychic);
                tvType1.setTextColor(Color.WHITE);
                break;
            case "Fighting":
                tvType1.setBackgroundResource(R.drawable.fighting);
                ivPokemon.setBackgroundResource(R.drawable.fighting);
                tvType1.setTextColor(Color.WHITE);
                break;
            case "Rock":
                tvType1.setBackgroundResource(R.drawable.rock);
                ivPokemon.setBackgroundResource(R.drawable.rock);
                tvType1.setTextColor(Color.WHITE);
                break;
            case "Steel":
                tvType1.setBackgroundResource(R.drawable.steel);
                ivPokemon.setBackgroundResource(R.drawable.steel);
                tvType1.setTextColor(Color.BLACK);
                break;
            case "Ice":
                tvType1.setBackgroundResource(R.drawable.ice);
                ivPokemon.setBackgroundResource(R.drawable.ice);
                tvType1.setTextColor(Color.BLACK);
                break;
            case "Ghost":
                tvType1.setBackgroundResource(R.drawable.ghost);
                ivPokemon.setBackgroundResource(R.drawable.ghost);
                tvType1.setTextColor(Color.BLACK);
                break;
            case "Dragon":
                tvType1.setBackgroundResource(R.drawable.dragon);
                ivPokemon.setBackgroundResource(R.drawable.dragon);
                tvType1.setTextColor(Color.BLACK);
                break;
        }

        if (item.types.size() > 1) {
            tvType2.setVisibility(View.VISIBLE);
            tvType2.setVisibility(View.VISIBLE);
            tvType2.setText(item.types.get(1).name.substring(0, 1).toUpperCase() + item.types.get(1).name.substring(1));

            switch (tvType2.getText().toString()) {
                case "Grass":
                    tvType2.setBackgroundResource(R.drawable.grass);
                    tvType2.setTextColor(Color.BLACK);
                    break;
                case "Poison":
                    tvType2.setBackgroundResource(R.drawable.poison);
                    tvType2.setTextColor(Color.WHITE);
                    break;
                case "Flying":
                    tvType2.setBackgroundResource(R.drawable.flying);
                    tvType2.setTextColor(Color.BLACK);
                    break;
                case "Fire":
                    tvType2.setBackgroundResource(R.drawable.fire);
                    tvType2.setTextColor(Color.WHITE);
                    break;
                case "Bug":
                    tvType2.setBackgroundResource(R.drawable.bug);
                    tvType2.setTextColor(Color.WHITE);
                    break;
                case "Water":
                    tvType2.setBackgroundResource(R.drawable.water);
                    tvType2.setTextColor(Color.WHITE);
                    break;
                case "Normal":
                    tvType2.setBackgroundResource(R.drawable.normal);
                    tvType2.setTextColor(Color.BLACK);
                    break;
                case "Electric":
                    tvType2.setBackgroundResource(R.drawable.electric);
                    tvType2.setTextColor(Color.BLACK);
                    break;
                case "Ground":
                    tvType2.setBackgroundResource(R.drawable.ground);
                    tvType2.setTextColor(Color.BLACK);
                    break;
                case "Fairy":
                    tvType2.setBackgroundResource(R.drawable.fairy);
                    tvType2.setTextColor(Color.BLACK);
                    break;
                case "Psychic":
                    tvType2.setBackgroundResource(R.drawable.psychic);
                    tvType2.setTextColor(Color.WHITE);
                    break;
                case "Fighting":
                    tvType2.setBackgroundResource(R.drawable.fighting);
                    tvType2.setTextColor(Color.WHITE);
                    break;
                case "Rock":
                    tvType2.setBackgroundResource(R.drawable.rock);
                    tvType2.setTextColor(Color.WHITE);
                    break;
                case "Steel":
                    tvType2.setBackgroundResource(R.drawable.steel);
                    tvType2.setTextColor(Color.BLACK);
                    break;
                case "Ice":
                    tvType2.setBackgroundResource(R.drawable.ice);
                    tvType2.setTextColor(Color.BLACK);
                    break;
                case "Ghost":
                    tvType2.setBackgroundResource(R.drawable.ghost);
                    tvType2.setTextColor(Color.BLACK);
                    break;
                case "Dragon":
                    tvType2.setBackgroundResource(R.drawable.dragon);
                    tvType2.setTextColor(Color.BLACK);
                    break;
            }
        } else {
            tvType2.setVisibility(View.GONE);
            tvType2.setVisibility(View.GONE);
        }
    }



    }







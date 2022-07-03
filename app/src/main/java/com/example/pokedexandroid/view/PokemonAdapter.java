package com.example.pokedexandroid.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
            TextView tvType1 = itemView.findViewById(R.id.tvType1);
            TextView tvType2 = itemView.findViewById(R.id.tvType2);


            if (item != null) {
                Glide.with(itemView.getContext()).load(item.imgUrl).into(ivPokemon);
                tvNumber.setText("№ " + item.formatedNumber);
                tvName.setText(item.formatedName);
                tvType1.setText(item.formatedType1);

                if (item.types.size() > 1) {
                    tvType2.setVisibility(View.VISIBLE);
                    //ERRO AO PASSAR PARA FORMATED TYPE2
                    tvType2.setText(item.types.get(1).name.substring(0, 1).toUpperCase() + item.types.get(1).name.substring(1));
                } else {
                    tvType2.setVisibility(View.GONE);
                }
            }

        }
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}



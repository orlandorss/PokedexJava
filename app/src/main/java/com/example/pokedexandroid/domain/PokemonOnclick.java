package com.example.pokedexandroid.domain;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.pokedexandroid.R;
import com.example.pokedexandroid.view.PokemonAdapter;

public class PokemonOnclick extends AppCompatActivity {

    public PokemonAdapter.ViewHolder items;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_description);

        TextView textView = findViewById(R.id.tv2Name);
        TextView tvNumber1 = findViewById(R.id.description_number);
        ImageView imageView = findViewById(R.id.imageView);
        String name = "Name not set";
        String number = "Number not set";
        String img = " ";


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            number = extras.getString("number");
            //CONTEM O IMGURL
            img = extras.getString("img");
        }
        Glide.with(getApplicationContext()).load(img).into(imageView);
        textView.setText(name);
        tvNumber1.setText("# " + number);

    }

}


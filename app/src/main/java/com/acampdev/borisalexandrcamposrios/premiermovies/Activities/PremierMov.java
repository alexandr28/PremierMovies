package com.acampdev.borisalexandrcamposrios.premiermovies.Activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.acampdev.borisalexandrcamposrios.premiermovies.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PremierMov extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premier_mov);

        // hide default actionbar
        getSupportActionBar().hide();

        // recibir Datos
        String name = getIntent().getExtras().getString("movie_name");
        String description = getIntent().getExtras().getString("movie_description");
        String category = getIntent().getExtras().getString("movie_category");
        String studio = getIntent().getExtras().getString("movie_studio");
        String rating = getIntent().getExtras().getString("movie_rating");
        String image_url = getIntent().getExtras().getString("movie_image_url");

        // init Views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbarID);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView movie_name= findViewById(R.id.aa_name);
        TextView movie_category= findViewById(R.id.aa_categories);
        TextView movie_description=findViewById(R.id.aa_description);
        TextView movie_studio=findViewById(R.id.aa_studio);
        TextView movie_rating=findViewById(R.id.aa_rating);
        ImageView movie_image=findViewById(R.id.aa_thumbnail);

        // setting values view

        movie_name.setText(name);
        movie_category.setText(category);
        movie_description.setText(description);
        movie_rating.setText(rating);
        movie_studio.setText(studio);

        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions= new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        // set using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(movie_image);
    }
}

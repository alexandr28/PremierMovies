package com.acampdev.borisalexandrcamposrios.premiermovies.POJOS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemResponse {

    @SerializedName("movies")
    @Expose
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
    public void setMovies(List<Movie> movies){
        this.movies=movies;
    }
}

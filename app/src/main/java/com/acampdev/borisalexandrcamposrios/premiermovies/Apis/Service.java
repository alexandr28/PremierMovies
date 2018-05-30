package com.acampdev.borisalexandrcamposrios.premiermovies.Apis;

import com.acampdev.borisalexandrcamposrios.premiermovies.POJOS.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("films")
    Call<ItemResponse> getMovies();
}

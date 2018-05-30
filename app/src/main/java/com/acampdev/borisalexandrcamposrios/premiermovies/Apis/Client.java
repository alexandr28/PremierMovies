package com.acampdev.borisalexandrcamposrios.premiermovies.Apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static final String BASE_URL="https://gist.githubusercontent.com/alexandr28/d7c88b29b7ad71ede19b91445b2f040e/raw/72e1579bf377b7744090c6b4b3c1160b957e0c46/films.json";
    public static Retrofit retrofit= null;

    public static Retrofit getClient(){
        try{
            if(retrofit == null){
                retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  retrofit;

    }


}

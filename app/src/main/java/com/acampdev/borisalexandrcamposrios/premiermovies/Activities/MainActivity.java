package com.acampdev.borisalexandrcamposrios.premiermovies.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.acampdev.borisalexandrcamposrios.premiermovies.Adapters.MovieAdapter;
import com.acampdev.borisalexandrcamposrios.premiermovies.POJOS.Movie;
import com.acampdev.borisalexandrcamposrios.premiermovies.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL="https://gist.githubusercontent.com/alexandr28/d7c88b29b7ad71ede19b91445b2f040e/raw/72e1579bf377b7744090c6b4b3c1160b957e0c46/films.json";
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private List<Movie> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesList= new ArrayList<>();
        recyclerView= (RecyclerView) findViewById(R.id.recyclerID);
        jsonrequest();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void jsonrequest(){

        jsonArrayRequest= new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {

                    try{
                        jsonObject=response.getJSONObject(i);
                        Movie movie= new Movie();
                        movie.setName(jsonObject.getString("name"));
                        movie.setDescription(jsonObject.getString("description"));
                        movie.setCategorie(jsonObject.getString("category"));
                        movie.setStudio(jsonObject.getString("studio"));
                        movie.setRating(jsonObject.getString("Rating"));
                        movie.setImage_url(jsonObject.getString("img"));
                        moviesList.add(movie);

                    }catch (Exception e){e.printStackTrace();}
                }
                setupRecyclerView(moviesList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);
    }

    private void setupRecyclerView(List<Movie> movies){

        MovieAdapter movieAdapter = new MovieAdapter(this,movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(movieAdapter);
    }
}

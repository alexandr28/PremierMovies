package com.acampdev.borisalexandrcamposrios.premiermovies.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.acampdev.borisalexandrcamposrios.premiermovies.Activities.PremierMov;
import com.acampdev.borisalexandrcamposrios.premiermovies.POJOS.Movie;
import com.acampdev.borisalexandrcamposrios.premiermovies.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    private Context context;
    private List<Movie> movies;
    RequestOptions requestOptions;

    public MovieAdapter(Context context,List<Movie> movies){
        this.context=context;
        this.movies=movies;
        requestOptions= new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        final LayoutInflater inflater= LayoutInflater.from(context);
        view= inflater.inflate(R.layout.movies_items,parent,false);
        final ViewHolder viewHolder= new ViewHolder(view);
        viewHolder.viewContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, PremierMov.class);
                intent.putExtra("movie_name",movies.get(viewHolder.getAdapterPosition()).getName());
                intent.putExtra("movie_description",movies.get(viewHolder.getAdapterPosition()).getDescription());
                intent.putExtra("movie_category",movies.get(viewHolder.getAdapterPosition()).getCategorie());
                intent.putExtra("movie_studio",movies.get(viewHolder.getAdapterPosition()).getStudio());
                intent.putExtra("movie_rating",movies.get(viewHolder.getAdapterPosition()).getRating());
                intent.putExtra("movie_image_url",movies.get(viewHolder.getAdapterPosition()).getImage_url());

                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(movies.get(position).getName());
        holder.cat.setText(movies.get(position).getCategorie());
        holder.rating.setText(movies.get(position).getRating());
        holder.studio.setText(movies.get(position).getStudio());

        // cargar Imagenes
        Glide.with(context).load(movies.get(position).getImage_url()).apply(requestOptions).into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,cat,studio,rating;
        ImageView poster;
        LinearLayout viewContainer;

        public ViewHolder(View itemView){
            super(itemView);
            viewContainer=itemView.findViewById(R.id.containerView);
            name=itemView.findViewById(R.id.name);
            cat=itemView.findViewById(R.id.categories);
            rating=itemView.findViewById(R.id.rating);
            studio=itemView.findViewById(R.id.studio);
            poster=itemView.findViewById(R.id.thumbnail);
        }
    }
}

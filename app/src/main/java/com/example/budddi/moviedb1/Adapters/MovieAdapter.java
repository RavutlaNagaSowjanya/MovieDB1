package com.example.budddi.moviedb1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.budddi.moviedb1.MainActivity;
import com.example.budddi.moviedb1.Model.MovieModel;
import com.example.budddi.moviedb1.MovieDetails;
import com.example.budddi.moviedb1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>
{
    Context context;
    ArrayList<MovieModel> movieModels;

    public MovieAdapter(MainActivity mainActivity, ArrayList<MovieModel> movieModels) {
        this.context=mainActivity;
        this.movieModels=movieModels;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view=LayoutInflater.from(context).inflate(R.layout.poster_design,viewGroup,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder movieViewHolder, final int i)
    {
        movieViewHolder.tv_title_display.setText(movieModels.get(i).getMovie_title());
        Picasso.with(context).load(" http://image.tmdb.org/t/p/w500/"+movieModels.get(i).getMovie_poster_image()).
        placeholder(R.drawable.ic_launcher_background).into(movieViewHolder.pimage);
        movieViewHolder.pimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] moviedetails=new String[7];
                moviedetails[0]=movieModels.get(i).getMovie_poster_image();
                moviedetails[1]=movieModels.get(i).getMovie_backdrop_image();
                moviedetails[2]=movieModels.get(i).getMovie_description();
                moviedetails[3]=movieModels.get(i).getMovie_rating();
                moviedetails[4]=movieModels.get(i).getMovie_release_date();
                moviedetails[5]=movieModels.get(i).getMovie_title();

                Intent intent=new Intent(context,MovieDetails.class);
                intent.putExtra("moviedetails",moviedetails);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_title_display;
        ImageView pimage;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title_display=itemView.findViewById(R.id.tv_title);
            pimage=itemView.findViewById(R.id.p_image);
        }
    }
}

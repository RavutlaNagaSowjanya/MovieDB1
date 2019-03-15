package com.example.budddi.moviedb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity
{
    ImageView movie_poster_image,movie_backdrop_image;
    TextView movie_title,movie_description,movie_rating,movie_release_date;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        movie_poster_image=findViewById(R.id.po_image);
        movie_backdrop_image=findViewById(R.id.b_image);
        movie_title=findViewById(R.id.m_title);
        movie_description=findViewById(R.id.m_desc);
        movie_rating=findViewById(R.id.m_rating);
        movie_release_date=findViewById(R.id.m_release_date);
        Intent intent=getIntent();
        String[] movie=intent.getStringArrayExtra("moviedetails");
        Picasso.with(this).load(" http://image.tmdb.org/t/p/w500/"+movie[0])
                .placeholder(R.drawable.ic_launcher_background).into(movie_poster_image);
        Picasso.with(this).load(" http://image.tmdb.org/t/p/w342/"+movie[1])
                .placeholder(R.drawable.ic_launcher_background).into(movie_backdrop_image);
        movie_description.setText(movie[2]);
        movie_rating.setText(movie[3]);
        movie_release_date.setText(movie[4]);
        movie_title.setText(movie[5]);
    }
}

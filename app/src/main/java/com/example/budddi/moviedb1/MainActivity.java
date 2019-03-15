package com.example.budddi.moviedb1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.budddi.moviedb1.Adapters.MovieAdapter;
import com.example.budddi.moviedb1.Model.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity
{
    ProgressBar progressBar;
    TextView error_tv;
    RecyclerView recyclerView;
    String popular_url="https://api.themoviedb.org/3/movie/popular?api_key=e1286b0a68b2b9743512cb534faa592e";
    String top_rated_url="https://api.themoviedb.org/3/movie/top_rated?api_key=e1286b0a68b2b9743512cb534faa592e";
    ArrayList<MovieModel> movieModels;
    String poster_image,backdrop_image,movie_id,
    mtitle,movie_description,mrating,mrelease_date;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progress);
        error_tv=findViewById(R.id.etv);
        recyclerView=findViewById(R.id.recycler);
        movieModels=new ArrayList<>();
        new MovieTask().execute(popular_url);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new MovieAdapter(this,movieModels));

    }

    public void showErrorMessage()
    {
        error_tv.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.popular:
                movieModels.clear();
                new MovieTask().execute(popular_url);
                break;

            case R.id.top_rated:
                movieModels.clear();
                new MovieTask().execute(top_rated_url);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    public class MovieTask extends AsyncTask<String ,Void,String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream=httpURLConnection.getInputStream();
                Scanner scanner=new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                if (scanner.hasNext()) {
                    return scanner.next();
                }
                else
                {
                    return null;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            progressBar.setVisibility(View.GONE);
            super.onPostExecute(s);
            if (s!=null) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        poster_image = jsonObject1.getString("poster_path");
                        backdrop_image = jsonObject1.getString("backdrop_path");
                        movie_id = jsonObject1.getString("id");
                        mtitle = jsonObject1.getString("title");
                        movie_description = jsonObject1.getString("overview");
                        mrating = jsonObject1.getString("vote_average");
                        mrelease_date = jsonObject1.getString("release_date");
                        movieModels.add(new MovieModel(poster_image, mtitle, backdrop_image, mrelease_date, mrating, movie_description, movie_id));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                showErrorMessage();
            }

        }

    }


}

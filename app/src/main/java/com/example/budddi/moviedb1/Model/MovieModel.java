package com.example.budddi.moviedb1.Model;

public class MovieModel
{
    String movie_poster_image,movie_title,movie_backdrop_image,movie_release_date,movie_rating,movie_description,movie_id;

    public MovieModel(String movie_poster_image, String movie_title, String movie_backdrop_image, String movie_release_date, String movie_rating, String movie_description, String movie_id) {
        this.movie_poster_image = movie_poster_image;
        this.movie_title = movie_title;
        this.movie_backdrop_image = movie_backdrop_image;
        this.movie_release_date = movie_release_date;
        this.movie_rating = movie_rating;
        this.movie_description = movie_description;
        this.movie_id = movie_id;
    }

    public String getMovie_poster_image() {

        return movie_poster_image;
    }

    public void setMovie_poster_image(String movie_poster_image) {
        this.movie_poster_image = movie_poster_image;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_backdrop_image() {
        return movie_backdrop_image;
    }

    public void setMovie_backdrop_image(String movie_backdrop_image) {
        this.movie_backdrop_image = movie_backdrop_image;
    }

    public String getMovie_release_date() {
        return movie_release_date;
    }

    public void setMovie_release_date(String movie_release_date) {
        this.movie_release_date = movie_release_date;
    }

    public String getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(String movie_rating) {
        this.movie_rating = movie_rating;
    }

    public String getMovie_description() {
        return movie_description;
    }

    public void setMovie_description(String movie_description) {
        this.movie_description = movie_description;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }
}

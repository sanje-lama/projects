package com.example.stl.myapplication.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.stl.myapplication.Movie;
import com.example.stl.myapplication.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView director;
    private TextView year;


    public MovieViewHolder(View itemView) {
        super(itemView);

        title =  itemView.findViewById(R.id.movie_title_textview);
        director = itemView.findViewById(R.id.movie_director_textview);
        year =  itemView.findViewById(R.id.movie_year_textview);

    }
    public void onBind(Movie movie) {
        title.setText("Title: " + movie.getTitle());
        director.setText("Director: " + movie.getDirector());
        year.setText("Year: " + movie.getYear());
    }
}

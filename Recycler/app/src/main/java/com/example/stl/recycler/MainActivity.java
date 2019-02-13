package com.example.stl.recycler;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.stl.recycler.controller.MovieAdapter;
import com.example.stl.recycler.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  RecyclerView movieRecyclerView;

  private TextView title;
  private TextView director;
  private TextView year;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.movie_title_textview);
        director = findViewById(R.id.movie_director_textview);
        year = findViewById(R.id.movie_year_textview);
        RecyclerView movieRecyclerView = findViewById(R.id.movie_recyclerview);

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Jaws", "Steven Spielberg", "1975"));
        movies.add(new Movie("Star Wars", "George Lucas", "1977"));
        movies.add(new Movie("Iron Man", "Jon Favreau", "2007"));
        movies.add(new Movie("The Avengers", "Joss Whedon","2011"));
        movies.add(new Movie("28 Days Later", "Danny Boyle", "2002"));
        movies.add(new Movie("Guardians of the Galaxy", "James Gunn", "2014"));
        movies.add(new Movie("Sneakers", "Phil Alden Robinson", "1992"));
        movies.add(new Movie("Clear and Present Danger", "Phillip Noyce", "1994"));
        movies.add(new Movie("Dazed and Confused", "Richard Linklater", "1993"));
        movies.add(new Movie("Primal fear", "Sidney Lumet", "1957"));
        movies.add(new Movie("THe Matrix", "Lana Wachowski", "1999"));
        movies.add(new Movie("The Mountain", "Darren Aronofsky", "2006"));


        MovieAdapter movieAdapter = new MovieAdapter(movies);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        movieRecyclerView.setAdapter(movieAdapter);

        movieRecyclerView.setLayoutManager(linearLayoutManager);

    }
}

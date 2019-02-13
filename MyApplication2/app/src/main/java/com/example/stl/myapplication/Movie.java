package com.example.stl.myapplication;

public class Movie {
    private String title;
    private String director;
    private String  year;


    public Movie(String title, String director, String year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }
}

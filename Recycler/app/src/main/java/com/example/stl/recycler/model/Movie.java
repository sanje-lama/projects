package com.example.stl.recycler.model;

    public class Movie {
        String title;
        String director;
        String year;

        public Movie(String title, String director, String year) {
            this.title = title;
            this.director = director;
            this.year = year;
        }
        public String getTitle() {
            return title;
        }
        public String getDirector() {
            return director;
        }
        public String getYear() {
            return year;

        }
    }


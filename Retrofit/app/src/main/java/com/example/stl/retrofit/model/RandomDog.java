package com.example.stl.retrofit.model;

public class RandomDog {


    // The variable names have to match the Json key(word for word)
    private String status;
    private String message;


    //Do not need setters.
    public String getUrl() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}


//Open a new Android Studio Project.
// Given the following JSON Endpoint:
//
//https://dog.ceo/api/breed/hound/images
//
//Use Retrofit to get the JSON Response,
// parse it into data models, then pass
// a list of the photos to a Grid RecyclerView.
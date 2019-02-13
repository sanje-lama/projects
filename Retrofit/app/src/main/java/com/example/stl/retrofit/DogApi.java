package com.example.stl.retrofit;

import com.example.stl.retrofit.model.RandomDog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogApi {
    String ENDPOINT_RANDOM_DOG = "api/breeds/image/random";




    @GET(ENDPOINT_RANDOM_DOG)
// Define a method,
    Call<RandomDog> getRandomPuppy();

}

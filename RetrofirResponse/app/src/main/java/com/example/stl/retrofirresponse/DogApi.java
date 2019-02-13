package com.example.stl.retrofirresponse;

import com.example.stl.retrofirresponse.model.DogBreeds;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogApi {
    String ENDPOINT_DOG = "https://dog.ceo/api/breed/hound/images";


@GET(ENDPOINT_DOG)
Call<List<DogBreeds>> getDogBreeds();
}

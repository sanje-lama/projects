package com.example.stl.retrofirresponse.view;


import com.example.stl.retrofirresponse.model.DogBreeds;

import java.util.List;

public class DogViewHolder extends RecycleListView.Adapter {

    private List<DogBreeds> dogBreeds;

public DogViewHolder(List<DogBreeds> dogBreeds) {
    this.dogBreeds = dogBreeds;


    }

}

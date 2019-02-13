package com.example.stl.retrofit;



     import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.stl.retrofit.model.RandomDog;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL_DOG_CEO = "https://dog.ceo";

    private ImageView dogView;
    private Button refreshDogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dogView = findViewById(R.id.dog_view);
        refreshDogs = findViewById(R.id.dog_button);

        final Retrofit retrofit = createRetrofit();
        refreshDogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofit.create(DogApi.class)
                        .getRandomPuppy()
                        .enqueue(new Callback<RandomDog>() {
                            @Override
                            public void onResponse(Call<RandomDog> call, Response<RandomDog> response) {
                                RandomDog responseDog = response.body();
                                Log.d("Working", "onResponse: " + responseDog.getUrl());

                                // implementation 'com.squareup.picasso:picasso:2.71828'
                                Picasso.with(getApplicationContext())
                                        .load(responseDog.getUrl())
                                        .into(dogView);
                            }

                            @Override
                            public void onFailure(Call<RandomDog> call, Throwable t) {
                                Log.d("Not working", "onFailure: " + t.getMessage());
                            }
                        });
            }
        });
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
        // Creating a retrofit instance or object:
        // Starts the builder process.


                // Gateway to our JSON endpoint.( Here we replaced the Url with a final String
                .baseUrl(BASE_URL_DOG_CEO)

                //  This takes care of our JSON serialization/deserialization
                .addConverterFactory(GsonConverterFactory.create())

                // This ends the transaction, returns a complete Retrofit instance.
                .build();
    }
}

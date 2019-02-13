package com.example.stl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject pokerHand = new JSONObject();


        // Right now the object is empty so lets start adding
        // keys and values to it but this will need to be
        // wrapped by a try catch block and use logcat to see
        // our new JSON object
        try {
            pokerHand.put("hand", new JSONArray()
                    .put(new JSONObject()
                            .put("rank", "Ace")
                            .put("suit", "CLUBS"))

                    .put(new JSONObject()
                            .put("rank", "King")
                            .put("suit", "DIAMONDS"))
                    .put(new JSONObject()
                            .put("rank", "Queen")
                            .put("suit", "HEARTS"))
                    .put(new JSONObject()
                            .put("rank", "Jack")
                            .put("suit", "SPADES"))
                    .put(new JSONObject()
                            .put("rank", "ten")
                            .put("suit", "CLUBS")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("JSON: ", "onCreate: " + pokerHand.toString());

        String jsonString = pokerHand.toString();
        Log.d("JSON", "onCreate:" + jsonString);

        // wrap our code in a try catch block in order to safely parse
        // the string into useful JSONObjects.
//
//        try {
//            JSONObject jsonParseObject = new JSONObject(jsonString);
//
//            JSONArray pokerHandArray = jsonParseObject.getJSONArray("hand");
//            List<Card> cards = new ArrayList<>();
//            for (int i = 0; i < pokerHandArray.length(); i++) {
//                String cardRank = (String) pokerHandArray.getJSONObject(i).get("rank");
//                Suit cardSuit = Suit.valueOf((String) pokerHandArray.getJSONObject(i).get("suit"));
//                Card card = new Card(cardRank, cardSuit);
//                cards.add(card);
//            }
//
//            for (Card card : cards) {
//                Log.d("JSON", "onCreate: " + "\nRank: " + card.getRank() +
//                        "\nSuit: " + card.getSuit());
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<PokerHand> jsonAdapter = moshi.adapter(PokerHand.class);

        try {
            PokerHand pokerHandObject = jsonAdapter.fromJson(jsonString);
            Log.d("JSON: ", "onCreate: " + pokerHandObject.getHand().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

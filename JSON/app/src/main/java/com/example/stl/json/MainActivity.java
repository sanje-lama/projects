package com.example.stl.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import com.squareup.moshi.Json;
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

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<PuppyResponse> jsonAdapter = moshi.adapter(PuppyResponse.class);
        String puppyUrl  = "";
        PuppyResponse savePuppyResponse;
        try {
            PuppyResponse puppyResponse =


        } catch (IOException e) {
            e.printStackTrace();
        }

        PuppyResponse puppyResponse = new PuppyResponse();
        List<String> urlList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(Hound.dogJson);

            JSONArray jsonArray = jsonObject.getJSONArray("message");

          //  Log.d("HOUND", " ", + jsonArray.length());

            for (int i = 0; i < jsonArray.length(); i++) {
                String url = jsonArray.getString(i);
                Log.d("HOUND","URL" + url);
                urlList.add(url);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        puppyResponse.setMessage(urlList);


//        JSONObject pokerHand = new JSONObject();
//
//
//        JSONObject pokerCard = new JSONObject();
//        try {
//            pokerCard.put("rank", "Five").put("suit", "spades");
//            pokerHand.put("cards", new JSONArray()).put(pokerCard).put(new JSONObject().put();
//            Log.d("POKER", "onCreate:" + "A card" + pokerCard.toString());
//            Log.d("POKER", "onCreate:" + "An array" + pokerCard.toString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//
//        }
//
//        JSONObject bicycle = new JSONObject();
//
//        try {
//            bicycle.put("bikes"
//        }





       // {"status":"success","message":{"affenpinscher":[],"african":[],"airedale":[],"akita":[],"appenzeller":[],"basenji":[],"beagle":[],"bluetick":[],"borzoi":[],"bouvier":[],"boxer":[],"brabancon":[],"briard":[],"bulldog":["boston","french"],"bullterrier":["staffordshire"],"cairn":[],"chihuahua":[],"chow":[],"clumber":[],"collie":["border"],"coonhound":[],"corgi":["cardigan"],"dachshund":[],"dane":["great"],"deerhound":["scottish"],"dhole":[],"dingo":[],"doberman":[],"elkhound":["norwegian"],"entlebucher":[],"eskimo":[],"germanshepherd":[],"greyhound":["italian"],"groenendael":[],"hound":["Ibizan","afghan","basset","blood","english","walker"],"husky":[],"keeshond":[],"kelpie":[],"komondor":[],"kuvasz":[],"labrador":[],"leonberg":[],"lhasa":[],"malamute":[],"malinois":[],"maltese":[],"mastiff":["bull","tibetan"],"mexicanhairless":[],"mountain":["bernese","swiss"],"newfoundland":[],"otterhound":[],"papillon":[],"pekinese":[],"pembroke":[],"pinscher":["miniature"],"pointer":["german"],"pomeranian":[],"poodle":["miniature","standard","toy"],"pug":[],"pyrenees":[],"redbone":[],"retriever":["chesapeake","curly","flatcoated","golden"],"ridgeback":["rhodesian"],"rottweiler":[],"saluki":[],"samoyed":[],"schipperke":[],"schnauzer":["giant","miniature"],"setter":["english","gordon","irish"],"sheepdog":["english","shetland"],"shiba":[],"shihtzu":[],"spaniel":["blenheim","brittany","cocker","irish","japanese","sussex","welsh"],"springer":["english"],"stbernard":[],"terrier":["american","australian","bedlington","border","dandie","fox","irish","kerryblue","lakeland","norfolk","norwich","patterdale","scottish","sealyham","silky","tibetan","toy","westhighland","wheaten","yorkshire"],"vizsla":[],"weimaraner":[],"whippet":[],"wolfhound":["irish"]}}
    }
}

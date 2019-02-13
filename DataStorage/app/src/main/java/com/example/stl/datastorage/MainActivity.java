package com.example.stl.datastorage;

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

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "Json Example";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





            JSONObject newJsonWeAreMaking = new JSONObject();

            try {
                newJsonWeAreMaking.put("family_members", new JSONArray()
                        .put(new JSONObject()
                                .put("name", "Jose")
                                .put("role", "Brother")
                                .put("age", 37))
                        .put(new JSONObject()
                                .put("name", "Ramona")
                                .put("role", "Sister")
                                .put("age", 40))
                        .put(new JSONObject()
                                .put("name", "Joe")
                                .put("role", "Father")
                                .put("age", 69))
                        .put(new JSONObject()
                                .put("name", "Barbara")
                                .put("role", "Mother")
                                .put("age", 71))
                        .put(new JSONObject()
                                .put("name", "Aida")
                                .put("role", "Partner")
                                .put("age", 41)));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            String jsonString = newJsonWeAreMaking.toString();

            Log.d(TAG, "onCreate: " + jsonString);

            try {
                JSONObject oldJsonWeAreParsing = new JSONObject(jsonString);
                JSONArray familyMembersJsonArray = oldJsonWeAreParsing.getJSONArray("family_members");
                List<FamilyMember> familyMemberList = new ArrayList<>();

                for (int i = 0; i < familyMembersJsonArray.length(); i++) {
                    FamilyMember member = new FamilyMember();
                    member.setName((String) familyMembersJsonArray.getJSONObject(i).get("name"));
                    member.setRole((String) familyMembersJsonArray.getJSONObject(i).get("role"));
                    member.setAge((Integer) familyMembersJsonArray.getJSONObject(i).get("age"));
                    familyMemberList.add(member);
                }

                for (FamilyMember fm : familyMemberList) {
                    Log.d(TAG, "onCreate: " +
                            "\nName - " + fm.getName() +
                            "\nRole - " + fm.getRole() +
                            "\nAge - " + fm.getAge());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
package com.example.stl.sqlfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.stl.sqlfromscratch.database.NoteDatabase;
import com.example.stl.sqlfromscratch.model.Note;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    private EditText messageText;
    private EditText nameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        messageText = findViewById(R.id.enter_message);
        nameText = findViewById(R.id.enter_name);
    }

    public void addNote(View view) {
        NoteDatabase noteDatabase = new NoteDatabase(this);
        String name = nameText.getText().toString();
        String message = messageText.getText().toString();
        Note note = new Note(name,message);
        noteDatabase.addNote(note);
        messageText.setText("");
        nameText.setText("");



    }
}

package com.example.stl.twoactivites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.stl.twoactivites;";

    public static final int TEXT_REQUEST = 1;

    private TextView replyTextView;

    private TextView getReplyTextView;

    private EditText messageEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        replyTextView = findViewById(R.id.text_header_reply);

        getReplyTextView = findViewById(R.id.text_message_reply);

        messageEditText = findViewById(R.id.editText_main);


    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button clicked");

        Intent intent = new Intent(this,SecondActivity.class);
        String message = messageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);
                replyTextView.setVisibility(View.VISIBLE);
                getReplyTextView.setText(reply);
                getReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}

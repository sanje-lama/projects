package com.example.stl.sqlfromscratch.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.stl.sqlfromscratch.R;
import com.example.stl.sqlfromscratch.model.Note;

import org.w3c.dom.Text;

public class SqlViewHoder extends RecyclerView.ViewHolder {
    private TextView messageText;
    private TextView nameText;

    public SqlViewHoder(@NonNull View itemView) {
        super(itemView);

        messageText = itemView.findViewById(R.id.name_textview);
        nameText = itemView.findViewById(R.id.message_textview);

    }
    public void onBind(Note text){
        messageText.setText(text.getMessage());
        nameText.setText(text.getName());

    }
}

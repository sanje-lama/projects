package com.example.stl.sqlfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stl.sqlfromscratch.R;
import com.example.stl.sqlfromscratch.model.Note;
import com.example.stl.sqlfromscratch.views.SqlViewHoder;

import org.w3c.dom.Text;

import java.util.List;

public class SqlAdapter extends RecyclerView.Adapter<SqlViewHoder> {

    private List<Note> noteList;

    public SqlAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public SqlViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        return new SqlViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SqlViewHoder sqlViewHoder, int i) {
        Note mynote = noteList.get(i);
        sqlViewHoder.onBind(mynote);

    }

    @Override
    public int getItemCount() {
        return noteList.size();

    }
}

package com.example.stl.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    public Context mContext;
    private List<String> dataSource;

    public CustomAdapter(String[] dataArgs, Context context) {
        dataSource = new ArrayList<>();
        for (int i = 0; i < dataArgs.length; i++) {
            dataSource.add(dataArgs[i]);
        }
        mContext = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView title;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.text);
            image = view.findViewById(R.id.image);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final String name =dataSource.get(position);
        final  int pos = position;
        holder.title.setText(dataSource.get(position));
        int resId = mContext.getResources().getIdentifier("n" + position, "drawable", mContext.getPackageName());
        holder.image.setImageDrawable(mContext.getResources().getDrawable(resId));

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextActivity(pos,name);
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextActivity(pos,name);
            }
        });

    }

    private void openNextActivity(int pos,String text) {
        Intent intent = new Intent(mContext,SecondActivity.class);
        intent.putExtra("name",text);
        intent.putExtra("imgname","n"+pos);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }


}



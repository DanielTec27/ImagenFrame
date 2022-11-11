package com.example.imagenframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<MyModel> model;

    public MyAdapter(Context context, int layout, ArrayList<MyModel> model) {
        this.context = context;
        this.layout = layout;
        this.model = model;
    }

    @Override
    public int getCount() {
        return this.model.size();
    }

    @Override
    public Object getItem(int position) {
        return this.model.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {


        View v = convertView;
        LayoutInflater layoutInflater  = LayoutInflater.from(this.context);
        if (convertView == null){
            v = layoutInflater.inflate(this.layout, null);
        } else {
            v = layoutInflater.inflate(this.layout, null);
        }
        String currentPath = this.model.get(position).getPath();
        String currentName = this.model.get(position).getName();
        TextView textView = v.findViewById(R.id.textView);
        ImageView imageView = v.findViewById(R.id.imageViewItem);
        textView.setText(currentName);

        Glide.with(this.context).load(currentPath).centerCrop().into(imageView);
        return v;
    }
}

package com.example.imagenframe;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class FrameVideo extends AppCompatActivity {

    private ArrayList<MyModel> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_video);
        ListView listView = findViewById(R.id.listView);

        String path = Environment.getExternalStorageDirectory().toString()+"/DCIM/Camera";
        Log.d("Files", "Path: " + path);
        File directory = new File(path);
            File[] files = directory.listFiles();
        reverse(files);
            Log.d("Files", "Size: "+ files.length);
            for (int i = 0; i < files.length; i++)
            {
                if(files[i].getName().contains(".mp4")) {
                    Log.d("Files", "FileName:" + files[i].getName());
                    items.add(new MyModel(files[i].getPath(),files[i].getName()));
                }
            }

        MyAdapter myAdapter = new MyAdapter(this,R.layout.preview_layout, items);
        listView.setAdapter(myAdapter);
    }

    static void reverse(File myArray[])
    {
        Collections.reverse(Arrays.asList(myArray));
    }

}
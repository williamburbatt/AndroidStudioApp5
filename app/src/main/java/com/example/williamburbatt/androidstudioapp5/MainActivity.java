package com.example.williamburbatt.androidstudioapp5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
                //dont change this... crashes too much
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] attraction = {"a","b","c","d","e"};
        //Need the adapter and to tell it what kind of list it's going into
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,attraction);
        //put them all into listview
        ListView lv = (ListView)findViewById(R.id.list1);
        lv.setAdapter(arr);

    }
}

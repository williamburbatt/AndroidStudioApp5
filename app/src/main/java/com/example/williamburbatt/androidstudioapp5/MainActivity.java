package com.example.williamburbatt.androidstudioapp5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

//dont change this... crashes too much
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] attraction = {"a","b","c","d","e"};
        //Need the adapter and to tell it what kind of list it's going into
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.activity_listview,attraction);
        //put them all into listview
        ListView lv = (ListView)findViewById(R.id.list1);
        lv.setAdapter(arr);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                switch (position) {
                    case 0:
                        //this tests new page passing position
                        Intent intent = new Intent(MainActivity.this, test2.class);
                        intent.putExtra("pos", position);
                        startActivity(intent);
                        break;
                    case 1:
                        //this tests linking to a website
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://sxu.edu")));
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "placeholder: " + position, Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "placeholder: " + position, Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "placeholder: " + position, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

}

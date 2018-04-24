package com.example.williamburbatt.androidstudioapp5;

import android.os.Bundle;
import android.widget.Toast;

public class test2 extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int position = getIntent().getIntExtra("pos", 0);
        Toast.makeText(test2.this, "position" + position, Toast.LENGTH_LONG).show();
    }
}

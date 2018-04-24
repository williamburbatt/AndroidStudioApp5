package com.example.williamburbatt.androidstudioapp5;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

//This page was created by William A Burbatt 4/24/18
//dont change this... crashes too much
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"Name", "Date of Birth", "Address", "Placeholder One", "Placeholder Two"};
        //Need the adapter and to tell it what kind of list it's going into WAB
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.activity_listview, items);
        //put them all into listview WAB
        ListView lv = (ListView) findViewById(R.id.list1);
        lv.setAdapter(arr);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                switch (position) {
                    case 0:
                        /**  //this tests new page passing position
                         Intent intent = new Intent(MainActivity.this, test2.class);
                         intent.putExtra("pos", position);
                         startActivity(intent);**/
                        //changed to method to popup screen, have to pass through header. WAB
                        popUp("Edit Name");
                        break;
                    case 1:
                        //this tests linking to a website WAB
                        popUp("Edit Date of Birth");
                        break;
                    case 2:
                        popUp("Edit Address");
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "placeholder arr: " + position, Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "placeholder arr: " + position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        backButton();
    }

    /**
     *
     * Triangle up top
     * WAB 4/24/18
     */
    public void backButton() {
        ImageView back = (ImageView) findViewById(R.id.imageView);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "To be implemented later ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Method to show pop-up screen. String s is header of popup depending on switch statement above
     * @param s
     * WAB 4/24/18
     */

    public void popUp(String s) {

        LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
    //Need to inflate the new page to root
        View layout = inflater.inflate(R.layout.layout_custom_dialog, null);
        //density helps make a cleaner popup
        float density = MainActivity.this.getResources().getDisplayMetrics().density;
        final PopupWindow pw = new PopupWindow(layout, (int) density * 440, (int) density * 300, true);
        //set up header
        ((TextView) layout.findViewById(R.id.h1)).setText(s);
        //Button to close the pop-up
        ((Button) layout.findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pw.dismiss();
                //close
            }
        });
        //tapping outside makes it close
        pw.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        //pop-up in the center
        pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
    }
}



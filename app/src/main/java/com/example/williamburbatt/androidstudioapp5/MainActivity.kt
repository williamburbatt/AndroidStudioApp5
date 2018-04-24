package com.example.williamburbatt.androidstudioapp5


import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*

//This page was created by William A Burbatt 4/24/18
//dont change this... crashes too much
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayOf("Name", "Date of Birth", "Address", "Placeholder One", "Placeholder Two")
        //Need the adapter and to tell it what kind of list it's going into WAB
        val arr = ArrayAdapter(this, R.layout.activity_listview, items)
        //put them all into listview WAB
        val lv = findViewById<View>(R.id.list1) as ListView
        lv.adapter = arr
        lv.onItemClickListener = AdapterView.OnItemClickListener { a, v, position, id ->
            when (position) {
                0 ->

                    //changed to method to popup screen, have to pass through header. WAB
                    popUp("Edit Name")
                1 ->
                    //this tests linking to a website WAB
                    popUp("Edit Date of Birth")
                2 -> popUp("Edit Address")
                3 -> Toast.makeText(this@MainActivity, "placeholder arr: $position", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(this@MainActivity, "placeholder arr: $position", Toast.LENGTH_SHORT).show()
            }
        }
        backButton()
    }

    /**
     *
     * Triangle up top
     * WAB 4/24/18
     */
    fun backButton() {
        val back = findViewById<View>(R.id.imageView) as ImageView
        back.setOnClickListener { Toast.makeText(this@MainActivity, "To be implemented later ", Toast.LENGTH_SHORT).show() }
    }

    /**
     * Method to show pop-up screen. String s is header of popup depending on switch statement above
     * @param s
     * WAB 4/24/18
     */

    fun popUp(s: String) {

        val inflater = LayoutInflater.from(this)
        //Need to inflate the new page to root
        val layout = inflater.inflate(R.layout.layout_custom_dialog, null)
        //density helps make a cleaner popup
        val density = this@MainActivity.resources.displayMetrics.density
        val pw = PopupWindow(layout, density.toInt() * 440, density.toInt() * 300, true)
        //set up header
        (layout.findViewById<View>(R.id.h1) as TextView).text = s
        //Button to close the pop-up
        (layout.findViewById<View>(R.id.button) as Button).setOnClickListener {
            pw.dismiss()
            //close
        }
        //tapping outside makes it close
        pw.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        //pop-up in the center
        pw.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }
}
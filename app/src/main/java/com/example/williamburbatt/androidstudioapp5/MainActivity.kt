package com.example.williamburbatt.androidstudioapp5


import android.accounts.Account
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

//This page was created by William A Burbatt 4/24/18
//dont change this... crashes too much
class MainActivity : AppCompatActivity() {

    private var listAccounts = ArrayList<MyAccount>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listAccounts.add(MyAccount(1, "JavaSampleApproach", "Java technology, Spring Framework - approach to Java by Sample."))
        listAccounts.add(MyAccount(2, "Kotlin Android Tutorial", "Create tutorial for people to learn Kotlin Android. Kotlin is now an official language on Android. It's expressive, concise, and powerful. Best of all, it's interoperable with our existing Android languages and runtime."))
        listAccounts.add(MyAccount(3, "Android Studio", "Android Studio 3.0 provides helpful tools to help you start using Kotlin. Convert entire Java files or convert code snippets on the fly when you paste Java code into a Kotlin file."))
        listAccounts.add(MyAccount(4, "Java Android Tutorial", "Create tutorial for people to learn Java Android. Learn Java in a greatly improved learning environment with more lessons, real practice opportunity, and community support."))
        listAccounts.add(MyAccount(5, "Spring Boot Tutorial", "Spring Boot help build stand-alone, production Spring Applications easily, less configuration then rapidly start new projects."))

        var accAdapter = AccountAdapter(this, listAccounts)
        val lv = findViewById<View>(R.id.list1) as ListView

        lv.adapter = accAdapter
        lv.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(this, "Click on " + listAccounts[position].title, Toast.LENGTH_SHORT).show()
        }
    }



    inner class AccountAdapter : BaseAdapter {

        private var accList = ArrayList<MyAccount>()
        private var context: Context? = null

        constructor(context: Context, notesList: ArrayList<MyAccount>) : super() {
            this.accList = notesList
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            val view: View?
            val vh: ViewHolder

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.activity_listview, parent, false)
                vh = ViewHolder(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ViewHolder
            }

            vh.accountTitle.text = accList[position].title
            vh.accountContent.text = accList[position].content

            return view
        }

        override fun getItem(position: Int): Any {
            return accList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return accList.size
        }
    }

    private class ViewHolder(view: View?) {
        val accountTitle: TextView = view?.findViewById(R.id.label) as TextView
        val accountContent: TextView = view?.findViewById(R.id.content) as TextView

        //  if you target API 26, you should change to:
//        init {
//            this.tvTitle = view?.findViewById<TextView>(R.id.tvTitle) as TextView
//            this.tvContent = view?.findViewById<TextView>(R.id.tvContent) as TextView
//        }
    }
}
    class MyAccount {

        var id: Int? = null
        var title: String? = null
        var content: String? = null

        constructor(id: Int, title: String, content: String) {
            this.id = id
            this.title = title
            this.content = content
        }

    }

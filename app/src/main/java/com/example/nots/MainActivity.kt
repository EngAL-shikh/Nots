package com.example.nots

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Nots
import com.example.myapplication.myAppDB
import com.example.newsapp.RecyclerNewsAdapter
import kotlinx.android.synthetic.main.activity_add_nots_activity.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nots_.*



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        add_nots_id.setOnClickListener {

            var intent = Intent(this, add_nots_activity::class.java)
            startActivity(intent)
        }
        ref_nots_id.setOnClickListener {
            shownots()
            Toast.makeText(this,"تم التحديث ", Toast.LENGTH_LONG).show()

        }
        shownots()








    }








fun shownots(){



    Thread{
        var db = myAppDB.invoke(this)

        var mynots=db.newsDao().getAllnews() as ArrayList

        mynots.forEach{

            runOnUiThread(Runnable{

                //gettitlenews.setText(it.title)


                var custoM= RecyclerNewsAdapter(this, mynots )

                rv.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
                rv.adapter=custoM

            })


        }
    }.start()
}




}

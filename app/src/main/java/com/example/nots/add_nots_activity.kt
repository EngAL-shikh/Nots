package com.example.nots

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Nots
import com.example.myapplication.myAppDB
import com.example.newsapp.RecyclerNewsAdapter
import kotlinx.android.synthetic.main.activity_add_nots_activity.*
import kotlinx.android.synthetic.main.activity_main.*

class add_nots_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nots_activity)



        save_nots_id.setOnClickListener {



            insertnots()

            Toast.makeText(this,"تم الحفظ",Toast.LENGTH_LONG).show()
            onBackPressed()

        }
    }

    fun insertnots(){





        var notslist=ArrayList<Nots>()
        var db = myAppDB.invoke(this)




        Thread{

            var nots =nots_id.text.toString()

            notslist.add(Nots(null,nots))

            for (n in notslist){

                db.newsDao().insert(n)
                Log.d("dkf","amroz")
            }






        }.start()








    }
}

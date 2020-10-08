package com.example.newsapp



import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Nots

import com.example.myapplication.myAppDB
import com.example.nots.R
import com.example.nots.updatenotsactivity
import kotlinx.android.synthetic.main.activity_nots_.view.*







class RecyclerNewsAdapter:RecyclerView.Adapter<RecyclerNewsAdapter.mViewHolder>



{

    var context:Context?=null

    var newslist=ArrayList<Nots>()


    constructor(context: Context,mNewslist:ArrayList<Nots>){
        this.newslist=mNewslist
        this.context=context


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {


        return mViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_nots_,parent,false))
    }

    override fun getItemCount(): Int {

        return newslist.size
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {



        var db=myAppDB.invoke(context!!)

        holder?.title.text=newslist.get(position).title+"\t"+newslist.get(position).id
        var b= holder?.title.text
        holder?.title.setOnClickListener {





            Thread{







                var current=newslist[position]
                current.title=b.toString()
                var d=db.newsDao().update(current)

                ((context as Activity)).runOnUiThread(Runnable {




                    notifyDataSetChanged()

                })



            }.start()

            var  intt=Intent(context,updatenotsactivity::class.java)
            intt.putExtra("nots",b)
            context!!.startActivity(intt)



        }















    }



    class mViewHolder(view: View):RecyclerView.ViewHolder(view)
    {

        var title=view.notsword
        var nots=view.notsword







    }

}
package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Nots::class],version = 1,exportSchema = false)
abstract class myAppDB:RoomDatabase() {

  abstract  fun newsDao():newsDao
    companion object{
        var db:myAppDB?=null

        fun invoke(context: Context):myAppDB {

            if (db==null){



                synchronized(myAppDB::class){

                    db= Room.databaseBuilder(context,myAppDB::class.java,"nots").build()

                    return db!!
                }
            }else {


                return db!!
            }




        }


    }
}
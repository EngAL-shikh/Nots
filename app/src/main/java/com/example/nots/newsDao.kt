package com.example.myapplication

import androidx.room.*


@Dao
interface newsDao {

    @Query("select * from nots")
    fun getAllnews():List<Nots>

    @Insert
    fun insert(news: Nots)


    @Update
    fun update(news: Nots)


    @Delete
    fun delete(news: Nots)
}
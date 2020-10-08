package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "nots")
data class Nots(
    @PrimaryKey(autoGenerate = true)
    var id: Int?
    , var title:String
    )



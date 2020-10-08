package com.example.nots

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.updatenotsactivity.*

class updatenotsactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.updatenotsactivity)



       var note= intent.extras!!.getString("nots")

        update_nots_id.setText(note)
    }
}

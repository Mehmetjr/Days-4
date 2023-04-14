package com.example.days_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {


    lateinit var txt_detail_data : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        txt_detail_data = findViewById(R.id.txt_detail_data)

       // actionBar?.setDisplayHomeAsUpEnabled(true)

        var data = intent.getStringExtra("data")
        txt_detail_data.text = data
        Toast.makeText(this,data,Toast.LENGTH_LONG).show()


    }
}
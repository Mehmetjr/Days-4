package com.example.days_4

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btn_add : Button
    lateinit var txt_data : EditText
    lateinit var cityListView : ListView
    var arr= mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataResult()
        btn_add = findViewById(R.id.btn_add)
        txt_data = findViewById(R.id.txtData)
        cityListView = findViewById(R.id.cityListView)

        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr)
        cityListView.adapter = adapter
        btn_add.setOnClickListener {


                addData(txt_data.text.toString())
                adapter.notifyDataSetChanged() // verimizi refresh ettik
                Toast.makeText(this,"Eleman eklendi",Toast.LENGTH_LONG).show()
                txt_data.setText("")
                txt_data.requestFocus() // imleci bu alana getirir
        }

        //click

        cityListView.setOnItemClickListener{ adapterView, view, i, l ->


            var intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("data", arr.get(i))
            startActivity(intent)

        }


        //long click
        cityListView.setOnItemLongClickListener{ adapterView, view, i, l ->

           // view.setBackgroundColor(Color.RED)
            arr.removeAt(i)
            adapter.notifyDataSetChanged()
            var item = arr.get(i)
            Toast.makeText(this,"$item eleman silindi",Toast.LENGTH_LONG).show()
            true
        }

        }
    fun dataResult(){

        for (item in 0..20){
            arr.add("$item - Title - ${UUID.randomUUID()}")
        }
    }

    fun addData(value : String){
        arr.add(value)
    }
    }


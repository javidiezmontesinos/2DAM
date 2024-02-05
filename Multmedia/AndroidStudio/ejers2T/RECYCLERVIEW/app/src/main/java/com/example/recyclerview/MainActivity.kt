package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personList = generatePersonList()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val personAdapter = PersonAdapter(personList)
        recyclerView.adapter = personAdapter
    }

    private fun generatePersonList(): List<Person> {
        return listOf(
            Person("Alberto","Rodriguez",",Málaga"),
            Person("Juan","De la Cruz",",Murcia"),
            Person("Eva","Diez",",Jaen"),
            Person("Alberto","San Juan",",Valencia"),
            Person("Laura","Perez",",Cadiz"),
            Person("Cristina","LaSant",",Barcelona"),
            Person("Isabel","SantJordi",",Badalona"),
            Person("Pedro","Santana",",Santander"),
            Person("Jose","Jolin",",Valencia"),
            Person("Manuel","Perez",",Albacete"),
            Person("Diana","Crush",",Kiev"),


            )
    }
}
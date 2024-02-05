package com.example.ejerciciomenubasictema6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainCardView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maincardview)

        val boton1 = findViewById<Button>(R.id.button1)
        boton1.setOnClickListener {
            navegarEjercicio1()
        }
    }

    private fun navegarEjercicio1() {
        val intent = Intent(this, Ejercicio3UusuarioPasswordActivity::class.java)
        startActivity(intent)
    }
}
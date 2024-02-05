package com.example.tema6layoutinflater

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Inflar el diseño XML
        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)

        // Obtener referencia al TextView inflado
        val textView = rootView.findViewById<TextView>(R.id.textView)


        // Configurar cualquier acción adicional si es necesario
        // ...


        // Establecer la vista inflada en la actividad
        setContentView(rootView)
    }
}

package com.example.ejersegundaappejer7

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainDatos : AppCompatActivity() {
    private var currentWeight: Int = 80
    private var currentAge: Int = 30

    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_datos)

        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        val etNombre: EditText = findViewById(R.id.etNombre)
        val etApellidos: EditText = findViewById(R.id.etApellidos)
        val etCurso: EditText = findViewById(R.id.etDireccion)
        val etAsignatura: EditText = findViewById(R.id.etGenero)
        val etNota: EditText = findViewById(R.id.etCP)
        val etEdad: TextView = findViewById(R.id.tvAge)  // Cambiado a TextView
        val etPeso: TextView = findViewById(R.id.tvWeight)  // Cambiado a TextView

        val cardViewUrgencia: CardView = findViewById(R.id.viewUrgencia)

        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        cardViewUrgencia.setOnClickListener {
            // Mostrar un Toast al pulsar el CardView de emergencia
            Toast.makeText(this, "¡Emergencia pulsada!", Toast.LENGTH_SHORT).show()
        }


        btnLogin.setOnClickListener(View.OnClickListener {
            // Obtener los valores de los EditText
            val nombre = etNombre.text.toString()
            val apellidos = etApellidos.text.toString()
            val curso = etCurso.text.toString()
            val asignatura = etAsignatura.text.toString()
            val nota = etNota.text.toString()
            val edad = etEdad.text.toString().toIntOrNull() ?: 0
            val peso = etPeso.text.toString().toIntOrNull() ?: 0

            // Crear un intent y pasar datos
            val intent = Intent(this@MainDatos, MostrarDatos::class.java)
            intent.putExtra("EXTRA_NAME", nombre)
            intent.putExtra("EXTRA_APELLIDOS", apellidos)
            intent.putExtra("EXTRA_CURSO", curso)
            intent.putExtra("EXTRA_ASIGNATURA", asignatura)
            intent.putExtra("EXTRA_NOTAS", nota)
            intent.putExtra("EXTRA_EDAD", edad)
            intent.putExtra("EXTRA_PESO", peso)

            // Iniciar la nueva actividad (MostrarDatos) con datos adicionales
            startActivity(intent)
        })
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }
}

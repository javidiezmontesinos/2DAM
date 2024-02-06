package com.example.ejersegundaappejer7

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MostrarDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)

        val resultadoname = findViewById<TextView>(R.id.tvResultName)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        resultadoname.text = "Nombre: $name"

        val resultadoapellidos = findViewById<TextView>(R.id.tvResultApellidos)
        val apellidos: String = intent.extras?.getString("EXTRA_APELLIDOS").orEmpty()
        resultadoapellidos.text = "Apellidos: $apellidos"

        val resultadocurso = findViewById<TextView>(R.id.tvResultCurso)
        val curso: String = intent.extras?.getString("EXTRA_CURSO").orEmpty()
        resultadocurso.text = "Direccion: $curso"

        val resultadoasignatura = findViewById<TextView>(R.id.tvResultAsignatura)
        val asignatura: String = intent.extras?.getString("EXTRA_ASIGNATURA").orEmpty()
        resultadoasignatura.text = "Genero: $asignatura"

        val resultadonotas = findViewById<TextView>(R.id.tvResultNotas)
        val notas: String = intent.extras?.getString("EXTRA_NOTAS").orEmpty()
        resultadonotas.text = "CP: $notas"

        val resultadoedad = findViewById<TextView>(R.id.tvInfo)
        val edad: Int = intent.extras?.getInt("EXTRA_EDAD") ?: 0
        val peso: Int = intent.extras?.getInt("EXTRA_PESO") ?: 0
        val emergenciaPulsada = intent.extras?.getBoolean("EXTRA_EMERGENCIA_PULSADA") ?: false
        resultadoedad.text = "Edad: $edad años || Peso: $peso kg || Emergencia: $emergenciaPulsada"


    }
}
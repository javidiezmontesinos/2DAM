package com.example.practica2t



import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultadoname = findViewById<TextView>(R.id.etNombre)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        resultadoname.text = "Nombre: $name"

        val resultadoapellidos = findViewById<TextView>(R.id.etApellidos)
        val apellidos: String = intent.extras?.getString("EXTRA_APELLIDOS").orEmpty()
        resultadoapellidos.text = "Apellidos: $apellidos"

        val resultadocurso = findViewById<TextView>(R.id.etDireccion)
        val curso: String = intent.extras?.getString("EXTRA_CURSO").orEmpty()
        resultadocurso.text = "Curso: $curso"

        val resultadoasignatura = findViewById<TextView>(R.id.etGenero)
        val asignatura: String = intent.extras?.getString("EXTRA_ASIGNATURA").orEmpty()
        resultadoasignatura.text = "Asignatura: $asignatura"


    }
}

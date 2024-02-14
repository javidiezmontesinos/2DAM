package com.example.tema7ejer2bbdd
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tema7ejer2bbd.DataManager

class MainActivity : AppCompatActivity() {

    private lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataManager = DataManager(this)

        val etNombres = findViewById<EditText>(R.id.etNombre)
        val etContraseñas = findViewById<EditText>(R.id.editTextPassword)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvMuestraNombre = findViewById<TextView>(R.id.tvMuestraNombre)

        btnAgregar.setOnClickListener {
            val nombre = etNombres.text.toString()
            val contraseña = etContraseñas.text.toString()
            dataManager.addName(nombre)
            dataManager.addPassword(contraseña)
            Toast.makeText(this, "Se agregó a la base de datos: $nombre", Toast.LENGTH_SHORT).show()
            etNombres.text.clear() // Limpiamos el componente EditText
        }

        // Muestra todos los datos
        btnMostrar.setOnClickListener {
            // Obtenemos los nombres y las contraseñas
            val nombres = dataManager.getAllNames()
            val contraseñas = dataManager.getAllPasswords()

            // Mostramos los nombres y las contraseñas en el TextView
            tvMuestraNombre.text = "Nombres:\n$nombres\nContraseñas:\n$contraseñas"
        }
    }
}
package com.example.proyectosqlite4simple

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataManager = DataManager(this)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etapellidos=findViewById<EditText>(R.id.etapellidos)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvMuestraNombre = findViewById<TextView>(R.id.tvMuestraNombre)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)
        val btnModificar = findViewById<Button>(R.id.btnModificar)

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            dataManager.addName(nombre)
            Toast.makeText(this, "Se agregó a la base de datos: $nombre", Toast.LENGTH_SHORT).show()
            etNombre.text.clear() //limpiamos el compononente editext
        }
        btnEliminar.setOnClickListener {
            val nombre = etNombre.text.toString()
            dataManager.deleteName(nombre)
            Toast.makeText(this, "Se eliminó de la base de datos: $nombre", Toast.LENGTH_SHORT).show()
            etNombre.text.clear()
        }

        btnModificar.setOnClickListener {
            val oldName = etNombre.text.toString()
            val newName = etapellidos.text.toString() // Suponiendo que "etapellidos" es un EditText para ingresar el nuevo nombre
            dataManager.updateName(oldName, newName)
            Toast.makeText(this, "Se actualizó el nombre en la base de datos: $oldName -> $newName", Toast.LENGTH_SHORT).show()
            etNombre.text.clear()
            // Aquí puedes limpiar también el EditText "etapellidos" si es necesario
        }
        // muestra todos los datos
        btnMostrar.setOnClickListener {
            // estamos instanciando la clase datamanager
            val nombres = dataManager.getAllNames(this)
            tvMuestraNombre.text = nombres //nos muestra los nombres que hay en la tabla
        }
    }
}

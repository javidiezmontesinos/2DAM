package com.example.simulacro2t

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    private var editTextNombre: EditText? = null
    private var editTextApellido: EditText? = null
    private var editTextDireccion: EditText? = null
    private var editTextCp: EditText? = null
    private var editTextCiudad: EditText? = null
    private var editTextProvincia: EditText? = null
    private var editTextTelefono: EditText? = null
    private lateinit var btnAgregar: Button
    private lateinit var btnMostrar: Button
    private lateinit var btnBorrar: Button
    private var textViewDatos: TextView? = null
    private var db: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Inicializar Firestore
        db = FirebaseFirestore.getInstance()
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextApellido = findViewById(R.id.editTextApellido)
        editTextDireccion= findViewById(R.id.editTextDireccion)
        editTextCp= findViewById(R.id.editTextCp)
        editTextCiudad= findViewById(R.id.editTextCiudad)
        editTextProvincia= findViewById(R.id.editTextProvincia)
        editTextTelefono= findViewById(R.id.editTextTelefono)
        btnAgregar = findViewById(R.id.btnAgregar)
        btnMostrar = findViewById(R.id.btnMostrar)
        btnBorrar = findViewById(R.id.btnBorrar)
        textViewDatos = findViewById(R.id.textViewDatos)
        btnAgregar.setOnClickListener(View.OnClickListener { agregarDatos() })
        btnMostrar.setOnClickListener(View.OnClickListener { mostrarDatos() })
        btnBorrar.setOnClickListener(View.OnClickListener { borrarDatos() })
    }

    private fun agregarDatos() {
        val nombre = editTextNombre!!.text.toString().trim()
        val apellido = editTextApellido!!.text.toString().trim()
        val direccion = editTextDireccion!!.text.toString().trim()
        val ciudad = editTextCiudad!!.text.toString().trim()
        val provincia = editTextProvincia!!.text.toString().trim()

        // Manejar conversiones seguras para CP y Teléfono
        val cpText = editTextCp!!.text.toString().trim()
        val telefonoText = editTextTelefono!!.text.toString().trim()

        // Verificar si los campos de CP y Teléfono no están vacíos antes de intentar convertir
        if (cpText.isNotEmpty() && telefonoText.isNotEmpty()) {
            try {
                val cp = cpText.toInt()
                val telefono = telefonoText.toInt()

                val user: MutableMap<String, Any> = HashMap()
                user["nombre"] = nombre
                user["apellido"] = apellido
                user["direccion"] = direccion
                user["cp"] = cp
                user["ciudad"] = ciudad
                user["provincia"] = provincia
                user["telefono"] = telefono

                db!!.collection("usuarios")
                    .add(user)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this@MainActivity,
                                "Datos agregados correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this@MainActivity,
                                "Error al agregar datos",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } catch (e: NumberFormatException) {
                // Handle the case where CP or Teléfono cannot be converted to Int
                Toast.makeText(
                    this@MainActivity,
                    "Por favor ingrese un valor válido para CP y Teléfono",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                this@MainActivity,
                "Por favor ingrese valores para CP y Teléfono",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun mostrarDatos() {
        db!!.collection("usuarios")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val datos = StringBuilder()
                    for (document in task.result) {
                        datos.append("Nombre: ").append(document.getString("nombre")).append(", ")
                            .append("Apellido: ").append(document.getString("apellido")).append(", ")
                            .append("Direccion: ").append(document.getString("direccion")).append(", ")
                            .append("cp: ").append(document.getString("cp")).append(", ")
                            .append("ciudad: ").append(document.getString("ciudad")).append(", ")
                            .append("provincia: ").append(document.getString("provincia")).append(", ")
                            .append("telefono: ").append(document.getString("telefono")).append(", ")
                            .append("")
                    }
                    textViewDatos!!.text = datos.toString()
                } else {
                    Toast.makeText(this@MainActivity, "Error al obtener datos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }


    private fun borrarDatos() {
        db!!.collection("usuarios")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        document.reference.delete()
                            .addOnSuccessListener {
                                Toast.makeText(
                                    this@MainActivity,
                                    "Datos eliminados correctamente",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(
                                    this@MainActivity,
                                    "Error al eliminar datos: ${e.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                    }
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Error al obtener datos para eliminar",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}

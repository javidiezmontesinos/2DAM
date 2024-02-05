package com.example.ficheros

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainFicheros : AppCompatActivity() {

    private lateinit var tvContenidoArchivo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCrearArchivo: Button = findViewById(R.id.btnCrearArchivo)
        val btnLeerArchivo: Button = findViewById(R.id.btnLeerArchivo)
        tvContenidoArchivo = findViewById(R.id.tvContenidoArchivo)

        btnCrearArchivo.setOnClickListener {
            crearArchivo()
        }

        btnLeerArchivo.setOnClickListener {
            leerArchivo()
        }
    }

    private fun crearArchivo() {
        try {
            val fileName = "Alberto_el_grande.txt"
            val fileContent = "Alberto_imperator"

            // Abrir un OutputStreamWriter en el modo privado (solo accesible por esta aplicación)
            val osw: OutputStreamWriter = OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE))

            // Escribir el contenido en el archivo
            osw.write(fileContent)

            // Limpiar y cerrar el OutputStreamWriter
            osw.flush() // limpiamos
            osw.close() // cerramos

            Log.d("Éxito", "Archivo creado con éxito!")
        } catch (e: Exception) {
            Log.e("Error", "Error al usar OutputStreamWriter: ${e.message}")
        }
    }

    private fun leerArchivo() {
        try {
            val fileName = "Alberto_el_grande.txt"
            val fileInputStream = openFileInput(fileName)
            val inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder = StringBuilder()
            var text: String?

            while (bufferedReader.readLine().also { text = it } != null) {
                stringBuilder.append(text).append("\n")
            }

            tvContenidoArchivo.text = stringBuilder.toString()

            Log.d("MainFicheros", "Contenido del archivo leído correctamente: $stringBuilder")

        } catch (e: Exception) {
            tvContenidoArchivo.text = "Error al leer el archivo: ${e.message}"
            Log.e("MainFicheros", "Error al leer el archivo: ${e.message}")
        }
    }
}

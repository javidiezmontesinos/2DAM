package com.example.simulacro2tejer2
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var textViewMessage: TextView
    private lateinit var videoView1: VideoView
    private lateinit var videoView2: VideoView
    private lateinit var videoView3: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Encuentra el ImageView en el layout
        val imageView = findViewById<ImageView>(R.id.imageCarro)

        // Cargar la animación desde un archivo XML
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotation)

        // Aplicar la animación al ImageView
        imageView.startAnimation(animation)

        // Animación para imageCarro2
        val imageView2 = findViewById<ImageView>(R.id.imageCarro2)
        val animation2: Animation = AnimationUtils.loadAnimation(this, R.anim.scale)
        imageView2.startAnimation(animation2)

// Animación para imageCarro3
        val imageView3 = findViewById<ImageView>(R.id.imageCarro3)
        val animation3: Animation = AnimationUtils.loadAnimation(this, R.anim.combined)
        imageView3.startAnimation(animation3)


        // Inicializar vistas
        editTextUsername = findViewById(R.id.editTextUsername)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        textViewMessage = findViewById(R.id.textViewMessage)
        videoView1 = findViewById(R.id.videoView1)
        videoView2 = findViewById(R.id.videoView2)
        videoView3 = findViewById(R.id.videoView3)

        val videoView = findViewById<VideoView>(R.id.videoView1)

        // Especifica la ruta del video
        val videoPath = "android.resource://${packageName}/${R.raw.video5}"
        val videoUri = Uri.parse(videoPath)

        // Configura el VideoView para reproducir el video
        videoView.setVideoURI(videoUri)

        // Configura los controles de reproducción del video
        val mediaController = android.widget.MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)

        // Inicia la reproducción del video
        videoView.start()

        // Especifica la ruta del video para videoView2
        val videoPath2 = "android.resource://${packageName}/${R.raw.video5}" // Reemplaza "tu_video_2" con el nombre de tu segundo video
        val videoUri2 = Uri.parse(videoPath2)

// Configura el VideoView para reproducir el video 2
        videoView2.setVideoURI(videoUri2)

// Configura los controles de reproducción del video 2
        val mediaController2 = android.widget.MediaController(this)
        videoView2.setMediaController(mediaController2)
        mediaController2.setAnchorView(videoView2)

// Inicia la reproducción del video 2
        videoView2.start()

// Especifica la ruta del video para videoView3
        val videoPath3 = "android.resource://${packageName}/${R.raw.video5}" // Reemplaza "tu_video_3" con el nombre de tu tercer video
        val videoUri3 = Uri.parse(videoPath3)

// Configura el VideoView para reproducir el video 3
        videoView3.setVideoURI(videoUri3)

// Configura los controles de reproducción del video 3
        val mediaController3 = android.widget.MediaController(this)
        videoView3.setMediaController(mediaController3)
        mediaController3.setAnchorView(videoView3)

// Inicia la reproducción del video 3
        videoView3.start()


        // Agregar evento clic al botón
        buttonSubmit.setOnClickListener {
            // Obtener nombre de usuario ingresado
            val username = editTextUsername.text.toString().trim()

            // Guardar nombre de usuario y fecha actual en archivo de texto
            guardarDatos(username)

            // Mostrar mensaje con Toast
            mostrarToast("¡Hola, $username! Bienvenido.")

            // Mostrar mensaje de registro
            Log.d("MainActivity", "Usuario '$username' ingresado el ${obtenerFechaActual()}")

            // Mostrar mensaje en TextView
            textViewMessage.text = "Bienvenido, $username"
        }
    }

    private fun guardarDatos(username: String) {
        try {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            val date = Date()
            val fechaActual = dateFormat.format(date)

            // Crear o abrir el archivo de texto para guardar los datos
            val fileOutputStream = openFileOutput("registro.txt", Context.MODE_APPEND)
            val outputStreamWriter = fileOutputStream.writer()

            // Escribir los datos en el archivo
            outputStreamWriter.appendln("Usuario: $username - Fecha de entrada: $fechaActual")

            // Cerrar el archivo de texto
            outputStreamWriter.close()
            fileOutputStream.close()

            Log.d("MainActivity", "Datos guardados en registro.txt")

        } catch (e: Exception) {
            Log.e("MainActivity", "Error al guardar datos: ${e.message}")
        }
    }

    private fun mostrarToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun obtenerFechaActual(): String {
        // Obtener fecha actual en el formato deseado (aquí va tu lógica para obtener la fecha actual)
        // Por ejemplo:
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
    }
}

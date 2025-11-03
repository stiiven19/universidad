package com.example.projecta.problemas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.example.projecta.HomeActivity
import com.example.projecta.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ForoActivityB : AppCompatActivity() {
    private lateinit var boton: AppCompatButton
    private lateinit var imageView: ImageView
    private lateinit var pregunta: String
    private lateinit var respuesta: String
    private lateinit var usuario :String
    private lateinit var userName :String
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foro_b)
        pregunta = intent.getStringExtra("pregunta")!!
        respuesta = intent.getStringExtra("respuesta")!!
        usuario = intent.getStringExtra("usuario")!!
        userName = intent.getStringExtra("username")!!

        val preguntaTextView = findViewById<TextView>(R.id.miPreguntaTextView)
        val respuestaTextView = findViewById<TextView>(R.id.misRespuestasTextViewb)
        boton = findViewById(R.id.btnEditar)
        imageView = findViewById(R.id.backImageForoB)

        imageView.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("openSecondFragment", true)
            startActivity(intent)
            finish()
        }
        preguntaTextView.text = pregunta
        if (respuesta != null) {
            respuestaTextView.text = respuesta
        }

        boton.setOnClickListener {
            editar()
        }
    }

    private fun editar() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Editar")

        // Crear un campo de entrada en el cuadro de diálogo
        val input = EditText(this)
        input.hint = "Edita tu pregunta"
        builder.setView(input)

        // Configurar los botones del cuadro de diálogo
        builder.setPositiveButton("Enviar") { _, _ ->
            val preguntap = input.text.toString()
            if(preguntap.isNotEmpty()){
                agregarRespuestaALaBaseDeDatos(preguntap)
                // No es necesario cargar las preguntas aquí, ya que el listener
                // actualizará automáticamente el RecyclerView
            } else {
                Toast.makeText(this, "Contenido vacío", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        // Mostrar el cuadro de diálogo
        builder.show()
    }

    private fun agregarRespuestaALaBaseDeDatos(preguntap: String) {

        val db = FirebaseFirestore.getInstance()
        db.collection("comunidad")
            .whereEqualTo("pregunta",pregunta)
            .whereEqualTo("respuesta",respuesta)
            .whereEqualTo("usuario", usuario)

            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val entryId = document.id
                    val preguntaDocument = db.collection("comunidad").document(entryId)
                    val nuevaPregunta = preguntap
                    preguntaDocument.update("pregunta", nuevaPregunta)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Pregunta modificada con éxito", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeActivity::class.java)
                            intent.putExtra("openSecondFragment", true)
                            startActivity(intent)
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Error al modificar pregunta", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }

    }
}
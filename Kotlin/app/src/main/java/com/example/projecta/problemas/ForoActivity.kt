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

class ForoActivity : AppCompatActivity() {

    private lateinit var boton: AppCompatButton
    private lateinit var imageView: ImageView
    private lateinit var pregunta: String
    private lateinit var respuesta: String
    private lateinit var usuario :String
    private lateinit var userName :String
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foro)

        pregunta = intent.getStringExtra("pregunta")!!
        respuesta = intent.getStringExtra("respuesta")!!
        usuario = intent.getStringExtra("usuario")!!
        userName = intent.getStringExtra("username")!!

        val preguntaTextView = findViewById<TextView>(R.id.preguntaTextView)
        val respuestaTextView = findViewById<TextView>(R.id.respuestaTextView)
        boton = findViewById(R.id.btnResponder)
        imageView = findViewById(R.id.backImageForo)

        imageView.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("openSecondFragment", true)
            startActivity(intent)
            finish()
        }
        preguntaTextView.text = "Usuario:"+ userName+"\n" +pregunta
        if (respuesta != null) {
            respuestaTextView.text = respuesta
        }

        boton.setOnClickListener {
            preguntar()
        }


    }

    private fun preguntar() {
        val user = FirebaseAuth.getInstance().currentUser
        var userNamep = user?.displayName
        if (userNamep == null || userNamep.isEmpty()) {
            userNamep = "Anonimo"
        }
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Responder")

        // Crear un campo de entrada en el cuadro de diálogo
        val input = EditText(this)
        input.hint = "Escribe tu respuesta"
        builder.setView(input)

        // Configurar los botones del cuadro de diálogo
        builder.setPositiveButton("Enviar") { _, _ ->
            val respuestap = input.text.toString()
            if(respuestap.isNotEmpty()){
                agregarRespuestaALaBaseDeDatos(respuestap,userNamep)
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

    private fun agregarRespuestaALaBaseDeDatos(respuestap: String, userNamep: String?) {
        val db = FirebaseFirestore.getInstance()

        db.collection("comunidad")
            .whereEqualTo("pregunta",pregunta)
            .whereEqualTo("respuesta",respuesta)
            .whereEqualTo("usuario", usuario)

            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val entryId = document.id
                    val respuestaDocument = db.collection("comunidad").document(entryId)
                    val nuevaRespuesta = respuesta + "\n" +"----------------------------" +"\n"+"Usuario:"+userNamep +"\n"+respuestap
                    respuestaDocument.update("respuesta", nuevaRespuesta)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Respuesta agregada con éxito", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeActivity::class.java)
                            intent.putExtra("openSecondFragment", true)
                            startActivity(intent)
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Error al editar respuesta", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
    }
}
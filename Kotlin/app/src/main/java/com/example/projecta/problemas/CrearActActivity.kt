package com.example.projecta.problemas

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.projecta.R
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class CrearActActivity : AppCompatActivity() {

    val db = Firebase.firestore
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_act)


        val btnCrearActividad: Button = findViewById(R.id.btnCrearActividad)
        val image: ImageView = findViewById(R.id.backImageCre)

        image.setOnClickListener {
            val intent = Intent(this, ProductividadActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnCrearActividad.setOnClickListener {
            // Obtén los valores de las vistas
            val descripcion = findViewById<EditText>(R.id.Descripcion).text.toString()
            val tiempoAsignado = findViewById<EditText>(R.id.tiempoas).text.toString().toIntOrNull() ?: 0
            val tiempoDescanso = findViewById<EditText>(R.id.tiempo).text.toString().toIntOrNull() ?: 0

            // Verifica que la descripción no esté vacía y el tiempo asignado sea mayor que cero
            if (descripcion.isNotEmpty() && tiempoAsignado > 0) {
                val user = FirebaseAuth.getInstance().currentUser
                val uid = user?.uid
                // Crea una nueva actividad
                // Agrega la actividad al ViewModel
                val db = FirebaseFirestore.getInstance()
                val actividadesCollection = db.collection("actividades")

// Crear un objeto de actividad
                val actividad = hashMapOf(
                    "descripcion" to descripcion,
                    "tiempoAsignado" to tiempoAsignado,
                    "tiempoDescanso" to tiempoDescanso,
                    "usuarioId" to uid // Agregar el UID del usuario como campo
                )

// Agregar la actividad a Firestore
                actividadesCollection
                    .add(actividad)
                    .addOnSuccessListener { documentReference ->
                        Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        Log.w(ContentValues.TAG, "Error adding document", e)
                    }

                Toast.makeText(this, "¡Actividad creada!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProductividadActivity::class.java)
                startActivity(intent)
                finish()
            }


// Add a new document with a generated ID

        }
    }
}


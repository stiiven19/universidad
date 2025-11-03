package com.example.projecta.problemas

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projecta.FiveFragment
import com.example.projecta.HomeActivity
import com.example.projecta.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.FieldPosition

class ProductividadActivity : AppCompatActivity() {
    private lateinit var rvAct : RecyclerView
    private lateinit var actividadesAdapter: ActividadesAdapter
    val actividadesList = mutableListOf<Actividad>()

    val db = Firebase.firestore
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productividad)

        val tipsTextView = findViewById<TextView>(R.id.tipsTextView)
        val btnCrear = findViewById<AppCompatButton>(R.id.btnCrearActividad)
        val image = findViewById<ImageView>(R.id.backImageProd)

        image.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("openFifthFragment", true)
            startActivity(intent)
            finish()
        }

        btnCrear.setOnClickListener {
            val intent = Intent(this, CrearActActivity::class.java)
            startActivity(intent)
        }

        tipsTextView.text = "• Debe crear un horario de actividades para mejorar su productividad.\n\n" +
                "• Para cada actividad, puedes asignar tiempos específicos.\n\n" +
                "• Se recomiendan bloques de 25 minutos, con 5 de descanso o " +
                "bloques de 50 minutos y 10 minutos de descanso"

        rvAct = findViewById(R.id.rvActividad)

        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid
        val actividadesCollection = db.collection("actividades")

// Obtener solo las actividades del usuario actual
        actividadesCollection.whereEqualTo("usuarioId", uid)
            .get()
            .addOnSuccessListener { documents ->

                for (document in documents) {
                    val data = document.data
                    val descripcion = data["descripcion"] as String
                    val tiempoAsignado = data["tiempoAsignado"] as Long
                    val tiempoDescanso = data["tiempoDescanso"] as Long

                    val actividad = Actividad(descripcion, tiempoAsignado, tiempoDescanso)
                    actividadesList.add(actividad)
                }

                actividadesAdapter = ActividadesAdapter(actividadesList,
                    onActividadSelected = { position -> onActividadSelected(position) },
                    onActividadLongClicked = { position -> onActividadLongClicked(position) })

                rvAct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                rvAct.adapter = actividadesAdapter
                // Actualizar el TextView con la información de las actividades

            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
            }




    }
    private fun updateActividad(){
        actividadesAdapter.notifyDataSetChanged()
    }

    private fun onActividadLongClicked(position: Int) {
        mostrarDialogoEliminarActividad(position)
    }

    private fun mostrarDialogoEliminarActividad(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar Actividad")
        builder.setMessage("¿Estás seguro de que deseas eliminar esta actividad?")

        builder.setPositiveButton("Eliminar") { _, _ ->
            // Eliminar la actividad y notificar al adaptador

            val user = FirebaseAuth.getInstance().currentUser
            val uid = user?.uid
            val db = FirebaseFirestore.getInstance()
            db.collection("actividades")
                .whereEqualTo("descripcion", actividadesList[position].descripcion)
                .whereEqualTo("tiempoAsignado", actividadesList[position].tiempoAsignado)
                .whereEqualTo("tiempoDescanso", actividadesList[position].tiempoDescanso)
                .whereEqualTo("usuarioId", uid)
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        val entryId = document.id

                        db.collection("actividades")
                            .document(entryId)
                            .delete()
                            .addOnSuccessListener {
                                Toast.makeText(this, "Actividad Eliminada con exito", Toast.LENGTH_SHORT).show()

                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                            }
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }



            actividadesList.removeAt(position)
            actividadesAdapter.notifyDataSetChanged()


        }

        builder.setNegativeButton("Cancelar") { _, _ ->
            // No hacer nada si se cancela la eliminación
        }

        builder.show()
    }

    private fun onActividadSelected(position: Int){
        actividadesList[position].isSelected = !actividadesList[position].isSelected
        val intent = Intent(this, TemporizadorActivity::class.java)
        intent.putExtra("tiempo", actividadesList[position].tiempoAsignado)
        intent.putExtra("tiempod", actividadesList[position].tiempoDescanso)
        updateActividad()
        startActivity(intent)
    }

}
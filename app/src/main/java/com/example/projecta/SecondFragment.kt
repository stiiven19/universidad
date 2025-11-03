package com.example.projecta

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projecta.R
import com.example.projecta.problemas.Actividad
import com.example.projecta.problemas.ActividadesAdapter
import com.example.projecta.problemas.ForoActivity
import com.example.projecta.problemas.ForoActivityB
import com.example.projecta.problemas.Pregunta
import com.example.projecta.problemas.PreguntasAdapter
import com.example.projecta.problemas.TemporizadorActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class SecondFragment : Fragment() {
    private lateinit var rvPr: RecyclerView
    private lateinit var preguntasAdapter: PreguntasAdapter
    private lateinit var btnHacerPregunta: AppCompatButton
    private val preguntasList = mutableListOf<Pregunta>()

    private val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        rvPr = view.findViewById(R.id.rvPreguntas)
        btnHacerPregunta = view.findViewById(R.id.btnHacerPregunta)

        btnHacerPregunta.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Hacer Pregunta")

            // Crear un campo de entrada en el cuadro de diálogo
            val input = EditText(requireContext())
            input.hint = "Escribe tu pregunta"
            builder.setView(input)

            // Configurar los botones del cuadro de diálogo
            builder.setPositiveButton("Enviar") { _, _ ->
                val pregunta = input.text.toString()
                if(pregunta.isNotEmpty()){
                    agregarPreguntaALaBaseDeDatos(pregunta)
                    // No es necesario cargar las preguntas aquí, ya que el listener
                    // actualizará automáticamente el RecyclerView
                } else {
                    Toast.makeText(requireActivity(), "Contenido vacío", Toast.LENGTH_SHORT).show()
                }
            }

            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }

            // Mostrar el cuadro de diálogo
            builder.show()
        }

        setupRecyclerView()

        // Agrega un listener para escuchar cambios en tiempo real en la colección "comunidad"
        db.collection("comunidad")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Log.w(ContentValues.TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    // Limpia la lista y agrega las preguntas actualizadas
                    preguntasList.clear()
                    for (document in snapshot.documents) {
                        val data = document.data
                        val preg = data?.get("pregunta") as String
                        val respuesta = data["respuesta"] as String
                        val usuario = data["usuario"] as String
                        var username = data?.get("username") as? String ?: "Anonimo"

                        if (username == null || username.isEmpty()) {
                            username = "Anonimo"
                        }

                        val pregunta = Pregunta(preg, respuesta, usuario,username)
                        preguntasList.add(pregunta)
                    }

                    // Notifica al adaptador que los datos han cambiado
                    preguntasAdapter.notifyDataSetChanged()
                } else {
                    Log.d(ContentValues.TAG, "Current data: null")
                }
            }

        return view
    }

    private fun setupRecyclerView() {
        preguntasAdapter = PreguntasAdapter(
            preguntasList,
            onPreguntaSelected = { position -> onPreguntaSelected(position) },
            onActividadLongClicked = { position -> onActividadLongClicked(position) }
        )

        rvPr.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        rvPr.adapter = preguntasAdapter
    }

    private fun agregarPreguntaALaBaseDeDatos(pregunta: String) {
        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid
        var userName = user?.displayName


        // Crea una nueva actividad
        // Agrega la actividad al ViewModel
        val db = FirebaseFirestore.getInstance()
        val comunidadCollection = db.collection("comunidad")
        val respuesta = ""
        // Crear un objeto de actividad
        val preguntaData = hashMapOf(
            "pregunta" to pregunta,
            "respuesta" to respuesta,
            "usuario" to uid,
            "username" to (userName ?: "Anonimo")
        )

        // Agregar la actividad a Firestore
        comunidadCollection
            .add(preguntaData)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }

        Toast.makeText(requireActivity(), "¡Actividad creada!", Toast.LENGTH_SHORT).show()
    }

    private fun updatePregunta(){
        preguntasAdapter.notifyDataSetChanged()
    }

    private fun onPreguntaSelected(position: Int) {


        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid
        if(preguntasList[position].usuario != uid ){
            val intent = Intent(requireActivity(), ForoActivity::class.java)
            intent.putExtra("pregunta", preguntasList[position].pregunta)
            intent.putExtra("respuesta", preguntasList[position].respuesta)
            intent.putExtra("username", preguntasList[position].username)
            intent.putExtra("usuario", preguntasList[position].usuario)
            startActivity(intent)
        }else{
            val intent = Intent(requireActivity(), ForoActivityB::class.java)
            intent.putExtra("pregunta", preguntasList[position].pregunta)
            intent.putExtra("respuesta", preguntasList[position].respuesta)
            intent.putExtra("usuario", preguntasList[position].usuario)
            intent.putExtra("username", preguntasList[position].username)

            startActivity(intent)
        }

    }
    private fun onActividadLongClicked(position: Int){
        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid
        if(preguntasList[position].usuario != uid ){

        }else{
            eliminarPregunta(position)
        }


        //intent.putExtra("tiempod", actividadesList[position].tiempoDescanso)
        updatePregunta()
    }

    private fun eliminarPregunta(position: Int) {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Eliminar Pregunta")
        builder.setMessage("¿Estás seguro de que deseas eliminar esta pregunta?")

        builder.setPositiveButton("Eliminar") { _, _ ->
            // Eliminar la actividad y notificar al adaptador

            val user = FirebaseAuth.getInstance().currentUser
            val uid = user?.uid
            val db = FirebaseFirestore.getInstance()
            db.collection("comunidad")
                .whereEqualTo("pregunta", preguntasList[position].pregunta)
                .whereEqualTo("respuesta", preguntasList[position].respuesta)
                .whereEqualTo("usuario", preguntasList[position].usuario)

                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        val entryId = document.id

                        db.collection("comunidad")
                            .document(entryId)
                            .delete()
                            .addOnSuccessListener {
                                Toast.makeText(requireActivity(), "Actividad Eliminada con exito", Toast.LENGTH_SHORT).show()

                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
                            }
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
                }



            preguntasList.removeAt(position)
            preguntasAdapter.notifyDataSetChanged()


        }

        builder.setNegativeButton("Cancelar") { _, _ ->
            // No hacer nada si se cancela la eliminación
        }

        builder.show()
    }
}

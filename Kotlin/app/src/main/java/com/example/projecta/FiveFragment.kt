package com.example.projecta

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment


import com.example.projecta.problemas.ProductividadActivity
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FiveFragment : Fragment() {

    private lateinit var btnGetAdvice: Button
    private lateinit var btnProduc: Button
    private lateinit var tipsTextView: TextView
    private lateinit var consejosList: ArrayList<String>
    private lateinit var googleSignInClient: GoogleSignInClient

    val db = Firebase.firestore

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_five, container, false)


        btnGetAdvice = view.findViewById(R.id.btnGetAdvice)
        btnProduc = view.findViewById<AppCompatButton>(R.id.btnProd2)
        tipsTextView = view.findViewById(R.id.tipsTextView)

        //var imagen = view.findViewById<ImageView>(R.id.out)

        /*imagen.setOnClickListener {
            Firebase.auth.signOut()
            googleSignInClient.signOut().addOnCompleteListener(){
                val intent = Intent(requireActivity(), FirstActivity::class.java)
                this.startActivity(intent)
            }

        }*/

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        traerConsejos()

        // Manejar el clic del botón para mostrar el consejo
        btnGetAdvice.setOnClickListener {
            obtenerConsejo()

        }

        btnProduc.setOnClickListener {
            val intenta = Intent(requireActivity(), ProductividadActivity::class.java)
            this.startActivity(intenta)
        }




    }

    private fun traerConsejos() {
        val collectionRef = Firebase.firestore.collection("consejos")

        collectionRef.get()
            .addOnSuccessListener { result ->
                consejosList = ArrayList()

                for (document in result) {
                    // Obtener el campo "consejo" del documento y agregarlo a la lista
                    val data = document.data
                    val consejo = data["consejo"] as String
                    consejosList.add(consejo)
                }
                obtenerConsejo()
            }
            .addOnFailureListener { exception ->
                // Manejar errores aquí
                // Por ejemplo, loguear el error
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    private fun obtenerConsejo() {
        if (consejosList.isNotEmpty()) {
            // Obtener un índice aleatorio de la lista
            val indiceAleatorio = (0 until consejosList.size).random()

            // Mostrar el consejo aleatorio en el TextView
            tipsTextView.text = consejosList[indiceAleatorio]
        } else {
            // Manejar el caso cuando no hay consejos disponibles
            tipsTextView.text = "No hay consejos disponibles."
        }

    }


}

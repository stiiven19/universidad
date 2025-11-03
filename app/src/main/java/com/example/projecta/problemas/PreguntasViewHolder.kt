package com.example.projecta.problemas

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projecta.R

class PreguntasViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val tpregunta:TextView = view.findViewById(R.id.tpregunta)


    fun render(pregunta: Pregunta){
        tpregunta.text = pregunta.pregunta
    }
}
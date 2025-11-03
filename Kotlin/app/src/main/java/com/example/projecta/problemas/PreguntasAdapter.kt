package com.example.projecta.problemas

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projecta.R
import com.google.firebase.auth.FirebaseAuth

class PreguntasAdapter(
    private val preguntas: List<Pregunta>,
    private val onPreguntaSelected: (Int) -> Unit,
    private val onActividadLongClicked: (Int) -> Unit
) : RecyclerView.Adapter<PreguntasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pregunta, parent, false)
        return PreguntasViewHolder(view)
    }

    override fun getItemCount() = preguntas.size

    override fun onBindViewHolder(holder: PreguntasViewHolder, position: Int) {
        holder.render(preguntas[position])
        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid

        // Restablecer los estilos por defecto
        holder.itemView.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.corner2)
        holder.itemView.findViewById<TextView>(R.id.tpregunta).setTextColor(
            ContextCompat.getColor(holder.itemView.context, R.color.black)
        )

        // Aplicar estilos solo si el usuario actual es el creador de la pregunta
        if (preguntas[position].usuario == uid) {
            holder.itemView.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.corner)
            holder.itemView.findViewById<TextView>(R.id.tpregunta).setTextColor(Color.WHITE)
        }

        holder.itemView.setOnClickListener { onPreguntaSelected(position) }

        holder.itemView.setOnLongClickListener {
            onActividadLongClicked(position)
            true // Indicar que el evento ha sido manejado
        }
    }

    fun usuario() {
        // Método adicional si es necesario
    }
}

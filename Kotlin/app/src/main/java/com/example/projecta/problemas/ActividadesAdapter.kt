package com.example.projecta.problemas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projecta.R

class ActividadesAdapter(private val actividades: List<Actividad>,
                         private val onActividadSelected : (Int) -> Unit,
                         private val onActividadLongClicked: (Int) -> Unit ) :RecyclerView.Adapter<ActividadesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActividadesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_actividad,parent,false)
        return ActividadesViewHolder(view)
    }

    override fun getItemCount() =  actividades.size


    override fun onBindViewHolder(holder: ActividadesViewHolder, position: Int) {
        holder.render(actividades[position])
        holder.itemView.setOnClickListener{ onActividadSelected(position) }
        holder.itemView.setOnLongClickListener {
            onActividadLongClicked(position)
            true // Indicar que el evento ha sido manejado
        }
    }

}
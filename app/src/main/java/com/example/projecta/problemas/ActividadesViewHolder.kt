package com.example.projecta.problemas

import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projecta.R
import org.w3c.dom.Text

class ActividadesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tactivi:TextView = view.findViewById(R.id.tactividad)
    private val chactivi:CheckBox = view.findViewById(R.id.chactividad)

    fun render(actividad: Actividad){
        if(actividad.isSelected){
            tactivi.paintFlags = tactivi.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tactivi.paintFlags = tactivi.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        chactivi.isChecked = actividad.isSelected
        
        tactivi.text = actividad.descripcion
    }
}
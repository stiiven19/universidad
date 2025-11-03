package com.example.projecta.problemas

import androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected

data class Actividad(
    val descripcion: String ,
    val tiempoAsignado: Long ,
    val tiempoDescanso: Long,
    var isSelected: Boolean = false
)


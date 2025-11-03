package com.example.recyclerviewreproductordemusica.reproductor

import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projecta.databinding.ItemTaskReminderBinding
import com.example.projecta.R

//class RemindersViewHolder(view : View ):RecyclerView.ViewHolder(view){
class RemindersViewHolder(val bind: ItemTaskReminderBinding):RecyclerView.ViewHolder(bind.root){

    private val tvReminder:TextView = bind.tvReminder
    //private val cbReminder:CheckBox = view.findViewById(R.id.cbReminder)
    private val btDelete:Button = bind.btDelete
    val btPlay:Button = bind.btplayitem


    fun render(reminder: Reminder){
        if (reminder.isSelected) {
            tvReminder.paintFlags = tvReminder.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvReminder.paintFlags = tvReminder.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        //tvReminder.text = reminder.title
        //cbReminder.isChecked = reminder.isSelected
        btDelete.isSelected = reminder.isSelected
        if (reminder.isPlaying) {

            btPlay.setBackgroundResource(R.drawable.baseline_pause_24)
            bind.rowCancion.setBackgroundColor(bind.rowCancion.context.getColor(R.color.splash))
            btPlay.invalidate()
        } else {
            //bind.rowCancion.setBackgroundColor(bind.rowCancion.context.getColor(R.color.purple_700))


            //Log.d("MiApp", "entro2")
            btPlay.setBackgroundResource(R.drawable.baseline_play_arrow_24)
            btPlay.invalidate()
        }

        //val color = when (reminder.category) {
        //    TaskReminder.Business -> R.color.purple_700
        //    TaskReminder.other -> R.color.purple_700
        //    TaskReminder.Personal -> R.color.purple_700
        // }

        //cbReminder.buttonTintList = ColorStateList.valueOf(
        //    ContextCompat.getColor(cbReminder.context, color)
        //)
        //tvReminder.text = reminder.name

    }
}
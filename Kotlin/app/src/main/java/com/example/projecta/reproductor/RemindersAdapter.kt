package com.example.recyclerviewreproductordemusica.reproductor

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected
import androidx.recyclerview.widget.RecyclerView
import com.example.projecta.R
import com.example.projecta.ThirdFragment
import com.example.projecta.databinding.ItemTaskReminderBinding

//class RemindersAdapter(//private val reminders:List<Reminder>,
                       //private val onReminderSelected: (Int) -> Unit,

                       //private val onNextSelected: (Int) -> Unit,
                       //private val onPreviousSelected: (Int) -> Unit
class RemindersAdapter(
                           private val reminders:List<Reminder>,
val con: ThirdFragment,
                           private val onPlaySelected: (Int) -> Unit,
                           private val recyclerView: RecyclerView
) : RecyclerView.Adapter<RemindersViewHolder>()
//RecyclerView.Adapter<RemindersViewHolder>()
{
   var selected = -1

    class ViewHolder(val bind: ItemTaskReminderBinding):RecyclerView.ViewHolder(bind.root) {
        val btplay = bind.btplayitem
        val rowCancion = bind.rowCancion
    }


    //override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemindersViewHolder {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemindersViewHolder {
        val view = ItemTaskReminderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_reminder, parent, false)
        return RemindersViewHolder(view)
        //return RemindersViewHolder(view)
    }




    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: RemindersViewHolder, position: Int) {
        //override fun onBindViewHolder(holder: RemindersViewHolder, position: Int) {
        //Log.d("MiApp", "posicion = ${position}")
        //Log.d("MiApp", "selected = ${selected}")
        //val elem = elementos[position]
        val elem = reminders[position]
        with(holder.bind){
            nombreCancionItem.text = elem.title

            if (position==selected){
                rowCancion.setBackgroundColor(con.resources.getColor(R.color.splash))
                //Log.d("MiApp", "entro")
                btplayitem.setBackgroundResource(R.drawable.baseline_pause_24)
            }else{
                rowCancion.setBackgroundColor(con.resources.getColor(R.color.purple_700))
                //Log.d("MiApp", "entro2")
                btplayitem.setBackgroundResource(R.drawable.baseline_play_arrow_24)
            }
            rowCancion.setOnClickListener{

                con.cancionActualIndex = position
                con.refreshSong()
                selected = position
                notifyDataSetChanged()
                //notifyItemChanged(position)
                //rowCancion.setBackgroundColor(con.resources.getColor(R.color.purple_700))
            }
            holder.btPlay.setOnClickListener {
                onPlaySelected(position) // Llama a la función lambda cuando se haga clic en el botón
                val itemView = holder.itemView
                val rowCancion = itemView.findViewById<LinearLayout>(R.id.rowCancion)
                val btPlay = itemView.findViewById<Button>(R.id.btplayitem)

                //rowCancion.setBackgroundColor(con.resources.getColor(R.color.splash))
                //btPlay.setBackgroundResource(R.drawable.baseline_pause_24)

                //rowCancion.setBackgroundColor(con.resources.getColor(R.color.purple_700))
                btPlay.setBackgroundResource(R.drawable.baseline_play_arrow_24)
            }
        }

        holder.render(reminders[position])
        //holder.itemView.setOnClickListener{onReminderSelected(position)}
        //var btDelete = holder.itemView.findViewById<View>(R.id.btDelete)
        //btDelete.setOnClickListener{onReminderSelected(position)}
        //var btPlay = holder.itemView.findViewById<View>(R.id.btplay)
        //btPlay.setOnClickListener{onPlaySelected(position)}


        //var btNext = holder.itemView.findViewById<View>(R.id.btnext)
        // btNext.setOnClickListener{onNextSelected(position)}
        //var btPrevious = holder.itemView.findViewById<View>(R.id.btprevious)
        //btPrevious.setOnClickListener{onPreviousSelected(position)}
    }

    override fun getItemCount() = reminders.size
    //override fun getItemCount() = elementos.size



    fun updatePlayState(position: Int) {
        //notifyItemChanged(position)
        //if (selected == -1 && position == 0)
        //if(selected != -1)
        //if(position != 999)
        selected=position
        notifyDataSetChanged()
        val viewHolder = recyclerView.findViewHolderForAdapterPosition(position) ?: return
        val btPlay = viewHolder.itemView.findViewById<Button>(R.id.btplayitem)
        if (con.mp.isPlaying) {
            btPlay.setBackgroundResource(R.drawable.baseline_pause_24)
        } else {
            btPlay.setBackgroundResource(R.drawable.baseline_play_arrow_24)
        }


    }

}
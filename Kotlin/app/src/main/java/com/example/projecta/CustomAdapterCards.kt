package com.example.projecta

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projecta.tips.Meditacion01
import com.example.projecta.tips.Meditacion02
import com.example.projecta.tips.Meditacion03
import com.example.projecta.tips.Tips
import com.google.firebase.firestore.FirebaseFirestore

class CustomAdapterCards: RecyclerView.Adapter<CustomAdapterCards.ViewHolder>() {

    val db: FirebaseFirestore = FirebaseFirestore.getInstance()




    val titulo = ArrayList<String>()
    val detalles = ArrayList<String>()
    val imagen = ArrayList<String>()


    //Metodo cuando entra por primera vez a crear la recyclerView
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)

    }

    //Cuando esta poblando cada elemento
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTittle.text = titulo[i]
        viewHolder.itemDetail.text = detalles[i]

        // Utiliza Glide para cargar la imagen desde la URL
        Glide.with(viewHolder.itemView.context)
            .load(imagen[i])
            .into(viewHolder.itemImage)
        //viewHolder.itemImage.text = imagen[i]

        //viewHolder.itemImage.setImageResource(imagen[i])
    }

    //tamaño del arreglo
    override fun getItemCount(): Int {
        return titulo.size
    }

    inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTittle: TextView
        var itemDetail: TextView

        init {
            //referenciar los elementos de la pantilla de la clase card_layout
            itemImage = itemView.findViewById(R.id.item_image)
            itemTittle = itemView.findViewById(R.id.title)
            itemDetail = itemView.findViewById(R.id.detail)

            itemView.setOnClickListener {
                // Acción a realizar al hacer clic en el elemento del RecyclerView
                val intent = Intent(itemView.context, Meditacion01::class.java)
                itemView.context.startActivity(intent)

            }
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTittle: TextView
        var itemDetail: TextView

        init {
            // Referenciar los elementos de la plantilla de la clase card_layout
            itemImage = itemView.findViewById(R.id.item_image)
            itemTittle = itemView.findViewById(R.id.title)
            itemDetail = itemView.findViewById(R.id.detail)

            itemView.setOnClickListener {
                // Obtener la posición del elemento para saber cual se seleccionó
                val position = adapterPosition

                // Verificar si la posición es válida
                if (position != RecyclerView.NO_POSITION) {
                    // Acción a realizar al hacer clic en el elemento del RecyclerView
                    val intent = when (position) {
                        0 -> Intent(itemView.context, Meditacion01::class.java)
                        1 -> Intent(itemView.context, Meditacion02::class.java)
                        2 -> Intent(itemView.context, Meditacion03::class.java)
                        3 -> Intent(itemView.context, Meditacion03::class.java)
                        4 -> Intent(itemView.context, Meditacion03::class.java)

                        else -> Intent(itemView.context, HomeActivity::class.java)
                    }

                    itemView.context.startActivity(intent)
                }
            }
        }
    }



    fun getTipsFromFirestore() {
        db.collection("tips")
            .get()
            .addOnSuccessListener { result ->
                val tipList = ArrayList<Tips>()

                for (document in result) {
                    val titulo = document.getString("titulo") ?: ""
                    val detalles = document.getString("detalles") ?: ""
                    val imagen = document.getString("imagen") ?: ""

                    //val imagen = document.getLong("imagen")?.toInt() ?: 0

                    val tip = Tips(titulo, detalles, imagen)
                    tipList.add(tip)
                }

                // Actualizar el adaptador con los datos recuperados
                updateAdapter(tipList)
            }
            .addOnFailureListener { exception ->
                // Manejar errores aquí
            }
    }








    fun updateAdapter(tipList: List<Tips>) {
        titulo.clear()
        detalles.clear()
        imagen.clear()

        tipList.forEach { tip ->
            titulo.add(tip.titulo)
            detalles.add(tip.detalles)
            imagen.add(tip.imagen)
        }

        notifyDataSetChanged()
    }



}
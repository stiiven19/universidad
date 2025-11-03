package com.example.projecta.tips

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.projecta.R
import com.google.firebase.firestore.FirebaseFirestore

class Meditacion05 : AppCompatActivity() {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private lateinit var viewPager: ViewPager2
    private lateinit var textView: TextView
    private lateinit var buttonPrevious: Button
    private lateinit var buttonNext: Button

    private val list = mutableListOf<CarouselItem>()
    private var currentImage: CarouselItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.carrousel)

        viewPager = findViewById(R.id.viewPager)
        textView = findViewById(R.id.textView)
        buttonPrevious = findViewById(R.id.buttonPrevious)
        buttonNext = findViewById(R.id.buttonNext)

        val adapter = CarouselAdapter(list)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                currentImage = list[position]
                textView.text = currentImage?.text
            }
        })

        buttonPrevious.setOnClickListener {
            viewPager.currentItem -= 1
        }

        buttonNext.setOnClickListener {
            viewPager.currentItem += 1
        }

        getTipsFromFirestore()
    }

    private fun getTipsFromFirestore() {
        db.collection("tips")
            .document("5")  // Reemplaza con el ID del documento que deseas obtener
            .collection("tip05")
            .get()
            .addOnSuccessListener { result ->
                list.clear()

                for (document in result) {
                    val imageUrl = document.getString("imagen") ?: ""
                    val text = document.getString("paso") ?: ""

                    val carouselItem = CarouselItem(imageUrl, text)
                    list.add(carouselItem)
                }

                viewPager.adapter?.notifyDataSetChanged()
                currentImage = list.firstOrNull()
                textView.text = currentImage?.text
            }
            .addOnFailureListener { exception ->
                // Manejar errores aquí
            }
    }

    data class CarouselItem(
        val imageUrl: String,
        val text: String
    )

    class CarouselAdapter(private val list: List<CarouselItem>) :
        RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

        inner class ViewHolder(val imageView: ImageView) :
            RecyclerView.ViewHolder(imageView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val imageView = ImageView(parent.context)
            imageView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            return ViewHolder(imageView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            Glide.with(holder.imageView.context)
                .load(item.imageUrl)
                .into(holder.imageView)
        }

        override fun getItemCount(): Int = list.size
    }
}
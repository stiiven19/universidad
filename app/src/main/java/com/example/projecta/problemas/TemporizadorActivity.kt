package com.example.projecta.problemas

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.projecta.FiveFragment
import com.example.projecta.R

class TemporizadorActivity : AppCompatActivity() {
    lateinit var trabajoTimer: CountDownTimer
    var descansoTimer: CountDownTimer = object : CountDownTimer(0, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            // No necesitas hacer nada en este caso
        }

        override fun onFinish() {
            // No necesitas hacer nada en este caso
        }
    }
    lateinit var tiempoRestanteTextView: TextView
    lateinit var progressBar: ProgressBar
    lateinit var tituloTextView: TextView

    lateinit var mediaPlayer: MediaPlayer



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temporizador)

        tiempoRestanteTextView = findViewById(R.id.tiempoRestanteTextView)
        tituloTextView = findViewById(R.id.titulo)
        progressBar = findViewById(R.id.progressBar)

        mediaPlayer = MediaPlayer.create(this, R.raw.timer)



        val tiempoAsignado = intent.getLongExtra("tiempo", 0)
        val tiempoDescanso = intent.getLongExtra("tiempod", 0)
        Log.d("TemporizadorActivity", "Tiempo asignado: $tiempoAsignado")

        val tiempoAsignadoMilisegundos = tiempoAsignado * 60 * 1000
        val handler = Handler(Looper.getMainLooper())

        progressBar.max = tiempoAsignado.toInt() * 60 // El máximo de la ProgressBar en segundos
        tituloTextView.text = "Tiempo de actividad"

        trabajoTimer = object : CountDownTimer(tiempoAsignadoMilisegundos, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                actualizarTiempoRestante(millisUntilFinished)
                actualizarProgressBar(millisUntilFinished)
            }

            override fun onFinish() {
                reproducirSonido()
                handler.postDelayed({
                    progressBar.max = tiempoDescanso.toInt() * 60
                    iniciarDescanso(tiempoDescanso)
                }, 4000)

            }
        }

        trabajoTimer.start()
        val image: ImageView = findViewById(R.id.backImageTim)
        image.setOnClickListener {
            Log.d("TemporizadorActivity", "Clic en la imagen")


            val intent = Intent(this, ProductividadActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun fin(){
        Toast.makeText(this, "¡Actividad completada!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ProductividadActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun iniciarDescanso(tiempoDescanso: Long) {
        tituloTextView.text = "Tiempo de descanso"
        val tiempoDescansoMilisegundos = tiempoDescanso * 60 * 1000
        progressBar.progress = progressBar.max // Reiniciar la ProgressBar
        val handler = Handler(Looper.getMainLooper())
        descansoTimer = object : CountDownTimer(tiempoDescansoMilisegundos, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                actualizarTiempoRestante(millisUntilFinished)
                actualizarProgressBar(millisUntilFinished)
            }

            override fun onFinish() {
                reproducirSonido()
                handler.postDelayed({
                    fin()
                }, 5000)

            }
        }
        descansoTimer.start()
    }
    private fun reproducirSonido() {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        trabajoTimer.cancel()
        descansoTimer.cancel()
        mediaPlayer.release()
    }

    private fun actualizarTiempoRestante(millisUntilFinished: Long) {
        val minutos = millisUntilFinished / 60000
        val segundos = (millisUntilFinished % 60000) / 1000
        tiempoRestanteTextView.text = String.format("%02d:%02d", minutos, segundos)
    }

    private fun actualizarProgressBar(millisUntilFinished: Long) {
        val segundosRestantes = millisUntilFinished / 1000
        progressBar.progress = segundosRestantes.toInt()
    }
}

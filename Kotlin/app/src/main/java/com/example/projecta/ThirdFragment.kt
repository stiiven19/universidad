package com.example.projecta

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.provider.OpenableColumns
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewreproductordemusica.reproductor.Reminder
import com.example.recyclerviewreproductordemusica.reproductor.RemindersAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream



class ThirdFragment : Fragment() {



    private lateinit var rvReminders: RecyclerView
    private lateinit var remindersAdapter: RemindersAdapter
    private lateinit var btAddReminder: FloatingActionButton
    private lateinit var seekBar: SeekBar
    private var vectormp = arrayOfNulls<MediaPlayer>(3)

    private var _fragmentView: View? = null
    private val fragmentView get() = _fragmentView!!

    val fd by lazy {
        requireContext().assets.openFd(cancionActual)
    }
    val mp by lazy {
        val m = MediaPlayer()
        m.setDataSource(
            fd.fileDescriptor,
            fd.startOffset,
            fd.length
        )
        fd.close()
        m.prepare()
        m
    }
    val controllers by lazy {
        listOf(R.id.btprevious, R.id.btplay, R.id.btnext).map {
            fragmentView.findViewById<MaterialButton>(it)
        }
    }
    object ci{
        val prev = 0
        val play = 1
        val next = 2
    }

    val nombreCancion by lazy {
        fragmentView.findViewById<TextView>(R.id.nombreCancion)
    }

    private val selectedSongs = mutableListOf<String>()

    val canciones by lazy {
        val nombreFicheros = requireContext().assets.list("")?.toList() ?: listOf()
        nombreFicheros.filter { it.contains(".mp3") }
    }
    val reminders by lazy {
        val reminderList = mutableListOf<Reminder>()
        for (cancion in canciones) {
            reminderList.add(Reminder(cancion))
        }
        reminderList
    }

    var cancionActualIndex = 0
        set(value){
            var v = if (value==-1){
                reminders.size-1
            }else{
                value%reminders.size
            }
            field = v
            cancionActual = reminders.get(v).title
        }
    lateinit var cancionActual:String

    val handler = Handler()
    val updateSeekBar = object : Runnable {
        override fun run() {
            activity?.runOnUiThread {
                seekBar?.progress = mp.currentPosition
            }
            handler.postDelayed(this, 100)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _fragmentView = view

        // Initialize views using the fragment's view
        seekBar = view.findViewById<SeekBar>(R.id.seekbar)

        // Setup click listeners
        controllers[ci.play].setOnClickListener(this::playClicked)
        controllers[ci.next].setOnClickListener(this::nextClick)
        controllers[ci.prev].setOnClickListener(this::prevClick)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mp.seekTo(progress)
                }
                if (!mp.isPlaying){
                    cancionActualIndex++
                    refreshSong()
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        btAddReminder = view.findViewById(R.id.btAddReminder)

        cancionActual = canciones[cancionActualIndex]
        nombreCancion.text="racessssssssssssssssssssssssssssssaaass.mp3"
        nombreCancion.isSelected = true // O bien:
        initComponent()
        //initUI()
        initListeners()
    }

    fun openFileExplorer() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "audio/*" // Filtrar solo archivos de audio
        startActivityForResult(intent, REQUEST_CODE_FILE_EXPLORER)
        remindersAdapter.updatePlayState(cancionActualIndex)
    }
    companion object {
        const val REQUEST_CODE_FILE_EXPLORER = 1000
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_FILE_EXPLORER && resultCode == Activity.RESULT_OK) {
            val uri = data?.data
            if (uri != null) {
                val cursor = requireActivity().contentResolver.query(uri, null, null, null, null)
                cursor?.use { cursor ->
                    val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    cursor.moveToFirst()
                    val fileName = cursor.getString(nameIndex)
                    Log.d("MiApp", "selected = $fileName")
                    handleSelectedSong(fileName)
                }
            }
        }
        remindersAdapter.updatePlayState(cancionActualIndex)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun handleSelectedSong(selectedSong: String) {
        val newReminder = Reminder(selectedSong)
        reminders.add(newReminder)
        // Update the adapter
        remindersAdapter.notifyItemInserted(reminders.size - 1)
        // Update the current song index if it's the first song
        if (reminders.size == 1) {
            cancionActualIndex = 0
        }
    }
    private fun moveSongToExternalFolder(assetFileName: String, folderPath: String, context: Context) {
        try {
            val assetManager = context.assets
            val inputStream: InputStream = assetManager.open(assetFileName)
            val folder = File(folderPath)
            val outputFile = File(folder, "$assetFileName.mp3")
            val outputStream: OutputStream = FileOutputStream(outputFile)
            inputStream.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
            inputStream.close()
            outputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun onStart() {
        super.onStart()
        rvReminders.apply {
            remindersAdapter = RemindersAdapter(reminders,
                this@ThirdFragment,
                { position -> onPlaySelected(position) },
                this
            )
            //remindersAdapter = RemindersAdapter(canciones, this@HomeActivity, playClicked)
            // remindersAdapter.updatePlayState(cancionActualIndex) // Actualiza el estado de reproducción
            layoutManager = LinearLayoutManager(requireContext())
            adapter = remindersAdapter // Asigna el adaptador al RecyclerView
        }
        btAddReminder.setOnClickListener {
            openFileExplorer()
        }


    }
    fun playClicked(v: View) {
        if (reminders.isEmpty()) {
            Toast.makeText(context, "No songs available", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            if (!mp.isPlaying) {
                if (mp.currentPosition > 0) {
                    // If song was paused, resume it
                    mp.start()
                } else if (cancionActualIndex < reminders.size) {
                    // Start playing the current song
                    refreshSong()
                    return
                }

                reminders[cancionActualIndex].isPlaying = true
                seekBar.max = mp.duration
                handler.postDelayed(updateSeekBar, 100)
                controllers[ci.play].setIconResource(R.drawable.baseline_pause_24)
                nombreCancion.visibility = View.VISIBLE
            } else {
                mp.pause()
                if (cancionActualIndex < reminders.size) {
                    reminders[cancionActualIndex].isPlaying = false
                }
                handler.removeCallbacks(updateSeekBar)
                controllers[ci.play].setIconResource(R.drawable.baseline_play_arrow_24)
            }

            // Update the play state in the adapter
            activity?.runOnUiThread {
                remindersAdapter.notifyItemChanged(cancionActualIndex)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    fun stopClicked(v:View){
        if (mp.isPlaying){
            mp.pause()
            handler.removeCallbacks(updateSeekBar)
            controllers[ci.play].setIconResource(R.drawable.baseline_play_arrow_24)
        }
        mp.seekTo(0)

    }

    fun nextClick (v:View){
        reminders.get(cancionActualIndex).isPlaying = false
        cancionActualIndex++
        refreshSong()
    }
    fun prevClick (v:View){
        mp.seekTo(0)
        reminders.get(cancionActualIndex).isPlaying = false
        seekBar.progress = 0
        cancionActualIndex--
        refreshSong()
    }
    fun refreshSong(){
        if (cancionActualIndex == -1) {
            cancionActualIndex = 0
            return
        }

        try {
            nombreCancion.text = ""
            mp.reset()

            if (cancionActualIndex < canciones.size) {
                // Handle built-in songs from assets
                val fd = requireContext().assets.openFd(cancionActual)
                mp.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
                fd.close()
            } else {
                // Handle user-added songs
                val file = File(requireContext().getExternalFilesDir(null), cancionActual)
                if (file.exists()) {
                    mp.setDataSource(file.absolutePath)
                } else {
                    Toast.makeText(context, "Error loading song", Toast.LENGTH_SHORT).show()
                    return
                }
            }

            mp.prepare()
            playClicked(controllers[ci.play])
            nombreCancion.text = cancionActual

            // Update the UI
            activity?.runOnUiThread {
                seekBar.max = mp.duration
                nombreCancion.visibility = View.VISIBLE
                // Update the RecyclerView to show the correct play state
                val previousIndex = if (cancionActualIndex > 0) cancionActualIndex - 1 else 0
                remindersAdapter.notifyItemChanged(previousIndex)
                remindersAdapter.notifyItemChanged(cancionActualIndex)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Error playing song: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initListeners() {
        btAddReminder.setOnClickListener{ showDialog()}
    }

    private fun showDialog(){
        //val dialog = Dialog(this)
        //dialog.setContentView(R.layout.dialog_reminder)

        //val btnAddReminder: Button = dialog.findViewById(R.id.btnAddReminder)
        //val etTask: EditText = dialog.findViewById(R.id.etTask)
        //val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        //btnAddReminder.setOnClickListener{
        //val selectedId = rgCategories.checkedRadioButtonId
        //val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
        //val currentCategory:TaskReminder = when(selectedRadioButton.text){
        // "Negocios" -> TaskReminder.Business
        // "Personal" -> TaskReminder.Personal
        //else -> TaskReminder.other
        //}
        reminders.add(Reminder(""))
        updateReminders()
        //dialog.hide()
        //}

        //dialog.show()
    }

    private fun initComponent(){
        rvReminders = fragmentView.findViewById(R.id.rvReminders)
        btAddReminder = fragmentView.findViewById(R.id.btAddReminder)
        vectormp[0] = MediaPlayer.create(requireContext(), R.raw.race)
        vectormp[1] = MediaPlayer.create(requireContext(), R.raw.sound)
        vectormp[2] = MediaPlayer.create(requireContext(), R.raw.tea)
    }

    /*private fun initUI(){
        this.remindersAdapter = RemindersAdapter(
            reminders,
            { position -> onItemSelected(position) },
            { position -> onPlaySelected(position) }
        )
        //remindersAdapter = RemindersAdapter(reminders) {position -> onItemSelected(position)}
        rvReminders.layoutManager = LinearLayoutManager(this)
        rvReminders.adapter = remindersAdapter
    }*/



    @SuppressLint("NotifyDataSetChanged")
    private fun updateReminders(){

        remindersAdapter.notifyDataSetChanged()
    }
    private fun onItemSelected(position: Int){

        reminders.removeAt(position)
        updateReminders()
    }
    private fun onPlaySelected(position: Int) {
        if (mp.isPlaying()) {
            if (cancionActualIndex == position) {
                mp.pause()
                handler.removeCallbacks(updateSeekBar)
                controllers[ci.play].setIconResource(R.drawable.baseline_play_arrow_24)
            } else {
                cancionActualIndex = position
                playClicked(controllers[ci.play])
            }
        } else {
            cancionActualIndex = position
            playClicked(controllers[ci.play])
        }



        /*    if (!reminders[position].isPlaying ){
                reminders[position].isPlaying = !reminders[position].isPlaying
                vectormp[0]?.start()


            }else{
                reminders[position].isPlaying = !reminders[position].isPlaying
                vectormp[0]?.pause()
                Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show()
            }
            updateReminders()
        */

    }


}
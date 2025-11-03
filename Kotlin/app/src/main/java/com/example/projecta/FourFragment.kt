package com.example.projecta

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.SetOptions
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

class FourFragment : Fragment() {

    private lateinit var entriesContainer: LinearLayout
    private lateinit var editTextEntry: EditText
    private lateinit var sharedPreferences: SharedPreferences
    private var enteredPassword: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_four, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        initializeMainScreen()
    }
    private fun initializeMainScreen() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            val view = requireView()
            editTextEntry = view.findViewById(R.id.editTextEntry)
            entriesContainer = view.findViewById(R.id.entriesContainer)

            val buttonAdd: AppCompatButton = view.findViewById(R.id.buttonAdd)
            buttonAdd.setOnClickListener {
                addEntry()
            }

            loadEntries()

            // Inicializar la contraseña al inicio
            enteredPassword = ""

            Log.d("InitializeMainScreen", "Entradas cargadas correctamente.")
        } else {
            showErrorDialog("Usuario no autenticado. Inicie sesión primero.")
            requireActivity().finish()
        }
    }

    private fun addEntry() {
        val newEntryText = editTextEntry.text.toString()

        if (newEntryText.isNotBlank()) {
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val currentDate = dateFormat.format(Date())

            Log.d("AddEntry", "Nueva entrada: $currentDate - $newEntryText")

            val entryLayout = createEntryLayout(currentDate, newEntryText)
            entriesContainer.addView(entryLayout)

            saveEntry(currentDate, newEntryText)

            editTextEntry.text.clear()
        }
    }

    private fun getRandomColor(): Int {
        return Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
    }

    private fun calculateContrastColor(color: Int): Int {
        val darkness =
            1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        return if (darkness < 0.5) Color.BLACK else Color.WHITE
    }

    private fun createEntryLayout(date: String, entryText: String): LinearLayout {
        val entryLayout = LinearLayout(requireContext())
        entryLayout.orientation = LinearLayout.VERTICAL

        val entryContainerParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        entryContainerParams.setMargins(16, 0, 16, 0)
        entryLayout.layoutParams = entryContainerParams

        val backgroundColor = getRandomColor()
        val textColor = calculateContrastColor(backgroundColor)

        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = 16f
        shape.setColor(backgroundColor)
        entryLayout.background = shape

        val dateTextView = TextView(requireContext())
        dateTextView.text = date
        dateTextView.textSize = 18f
        dateTextView.setTypeface(null, Typeface.BOLD)
        dateTextView.setTextColor(textColor)
        entryLayout.addView(dateTextView)

        val entryTextView = TextView(requireContext())
        entryTextView.text = entryText
        entryTextView.textSize = 16f
        entryTextView.setTextColor(textColor)
        entryLayout.addView(entryTextView)

        entryLayout.setOnClickListener {
            editTextEntry.setText(entryText)
            entryLayout.visibility = View.GONE
            deleteEntry(date, entryText)
        }

        entryLayout.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editTextEntry.requestFocus()
            }
        }

        entryLayout.setOnLongClickListener {
            showDeleteEntryDialog(date, entryText)
            true
        }

        return entryLayout
    }

    private fun showDeleteEntryDialog(date: String, entryText: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Eliminar Entrada")
        builder.setMessage("¿Seguro que deseas eliminar esta entrada?")

        builder.setPositiveButton("Sí") { _, _ ->
            deleteEntry(date, entryText)
        }

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }

    private fun saveEntry(date: String, entryText: String) {
        val db = FirebaseFirestore.getInstance()
        val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid

        if (currentUserUid != null) {
            val entry = hashMapOf(
                "date" to date,
                "entryText" to entryText,
                "userUid" to currentUserUid
            )

            db.collection("entries")
                .add(entry)
                .addOnSuccessListener { documentReference ->
                    editTextEntry.text.clear()
                    loadEntries()
                }
                .addOnFailureListener { e ->
                    showErrorDialog("Error al guardar la entrada en Firestore: ${e.message}")
                }
        }
    }

    private fun loadEntries() {
        val db = FirebaseFirestore.getInstance()
        val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid

        if (currentUserUid != null) {
            db.collection("entries")
                .whereEqualTo("userUid", currentUserUid)
                .orderBy("date", Query.Direction.DESCENDING)
                .get()
                .addOnSuccessListener { result ->
                    Log.d("LoadEntries", "Éxito al obtener documentos. Cantidad: ${result.size()}")
                    for (document in result) {
                        val date = document.getString("date")
                        val entryText = document.getString("entryText")

                        if (date != null && entryText != null) {
                            if (!entryExists(date, entryText)) {
                                val entryLayout = createEntryLayout(date, entryText)
                                entriesContainer.addView(entryLayout)
                            }

                            Log.d("LoadEntries", "Entrada cargada: $date - $entryText")
                        }
                    }
                }
                .addOnFailureListener { e ->
                    showErrorDialog("Error al cargar las entradas desde Firestore: ${e.message}")
                    Log.e("LoadEntries", "Error al cargar las entradas desde Firestore", e)
                }
        }
    }

    private fun entryExists(date: String, entryText: String): Boolean {
        for (i in 0 until entriesContainer.childCount) {
            val childView = entriesContainer.getChildAt(i)
            if (childView is LinearLayout) {
                val dateTextView = childView.getChildAt(0) as TextView
                val entryTextView = childView.getChildAt(1) as TextView
                if (dateTextView.text == date && entryTextView.text == entryText) {
                    return true
                }
            }
        }
        return false
    }

    private fun getPassword(): String? {
        return sharedPreferences.getString("password", "")
    }

    private fun setPassword(password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("password", password)
        editor.apply()
    }

    private fun showErrorDialog(message: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar", null)
        builder.show()
    }

    private fun editEntry(date: String, entryText: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Editar Entrada")

        val input = EditText(requireContext())
        input.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
        input.setText(entryText)
        builder.setView(input)

        builder.setPositiveButton("Guardar") { _, _ ->
            val editedText = input.text.toString()
            updateEntry(date, editedText)
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }

    private fun updateEntry(date: String, newEntryText: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection("entries")
            .whereEqualTo("date", date)
            .whereEqualTo("entryText", newEntryText)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val entryId = document.id
                    val updatedEntry = hashMapOf(
                        "entryText" to newEntryText
                    )

                    db.collection("entries")
                        .document(entryId)
                        .update(updatedEntry as Map<String, Any>)
                        .addOnSuccessListener {
                            updateEntryInUI(date, newEntryText)
                        }
                        .addOnFailureListener { e ->
                            showErrorDialog("Error al actualizar la entrada en Firestore: ${e.message}")
                        }
                }
            }
            .addOnFailureListener { e ->
                showErrorDialog("Error al buscar la entrada en Firestore: ${e.message}")
            }
    }

    private fun updateEntryInUI(date: String, newEntryText: String) {
        for (i in 0 until entriesContainer.childCount) {
            val childView = entriesContainer.getChildAt(i)
            if (childView is LinearLayout) {
                val dateTextView = childView.getChildAt(0) as TextView
                val entryTextView = childView.getChildAt(1) as TextView
                if (dateTextView.text == date && entryTextView.text == newEntryText) {
                    entryTextView.text = newEntryText
                    childView.visibility = View.VISIBLE
                    break
                }
            }
        }
    }

    private fun deleteEntry(date: String, entryText: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection("entries")
            .whereEqualTo("date", date)
            .whereEqualTo("entryText", entryText)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val entryId = document.id

                    db.collection("entries")
                        .document(entryId)
                        .delete()
                        .addOnSuccessListener {
                            deleteEntryFromUI(date, entryText)
                        }
                        .addOnFailureListener { e ->
                            showErrorDialog("Error al eliminar la entrada en Firestore: ${e.message}")
                        }
                }
            }
            .addOnFailureListener { e ->
                showErrorDialog("Error al buscar la entrada en Firestore: ${e.message}")
            }
    }

    private fun deleteEntryFromUI(date: String, entryText: String) {
        for (i in 0 until entriesContainer.childCount) {
            val childView = entriesContainer.getChildAt(i)
            if (childView is LinearLayout) {
                val dateTextView = childView.getChildAt(0) as TextView
                val entryTextView = childView.getChildAt(1) as TextView
                if (dateTextView.text == date && entryTextView.text == entryText) {
                    entriesContainer.removeViewAt(i)
                    break
                }
            }
        }
    }
}

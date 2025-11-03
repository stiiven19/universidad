package com.example.projecta

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.example.projecta.databinding.ActivityFirstBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth

class FirstActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityFirstBinding
    private lateinit var googleAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = com.google.firebase.ktx.Firebase.auth
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this,gso)

        binding.about.setOnClickListener { showAboutDialog() }
        binding.google.setOnClickListener {
            googleSignIn()
        }
        binding.signInAppCompatButton.setOnClickListener {
            val mEmail = binding.tUsuario.text.toString()
            val mPassword = binding.tContraseA.text.toString()

            when {
                mPassword.isEmpty() || mEmail.isEmpty() -> {
                    Toast.makeText(this, "Email o contraseña o incorrectos.",
                        Toast.LENGTH_SHORT).show()
                }
                else -> {
                    signIn(mEmail, mPassword)
                }
            }

        }
        binding.signUpTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            this.startActivity(intent)
        }
        binding.recoveryAccountTextView.setOnClickListener {
            val intent = Intent(this, AccountRecoveryActivity::class.java)
            this.startActivity(intent)
        }


    //setup()
    }

    private fun googleSignIn() {
        val signInClient = googleSignInClient.signInIntent
        launcher.launch(signInClient)
    }
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->

        if(result.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)

            manageResults(task)
        }
    }

    private fun manageResults(task: Task<GoogleSignInAccount>) {
        val account : GoogleSignInAccount? = task.result

        if (account != null){
            val credential = GoogleAuthProvider.getCredential(account.idToken, null )
            auth.signInWithCredential(credential).addOnCompleteListener(){
                if(task.isSuccessful){
                    val intent = Intent(this,HomeActivity::class.java )
                    startActivity(intent)
                    Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
        else{
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("TAG", "signInWithEmail:success")
                    reload()
                } else {
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Email o contraseña o incorrectos.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun reload() {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }

    private fun showAboutDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Integrantes")
            .setMessage("-Jorge Rojas - Stiven Guerrero - Jesus Guerrero - Rafael Lopez.")
            .setPositiveButton("OK") { dialog: DialogInterface, which: Int ->
                // Acción al hacer clic en "OK"
            }
            .show()
    }

  /*  private fun setup() {

        val bRegistrar = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.registrar)
        val temail = findViewById<EditText>(R.id.tUsuario)
        val contra = findViewById<EditText>(R.id.tContraseña)
        val bAcceder = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.Acceder)
        val bAbout = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.about)
        title = "Autentication"
        bRegistrar.setOnClickListener {
            if(temail.text.isNotEmpty() && contra.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(temail.text.toString(),
                    contra.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this,HomeActivity::class.java)
                        intent.putExtra("temail",temail.text)
                        startActivity(intent)
                    }else{
                     showAlert()
                    }
                }
            }
        }
        bAcceder.setOnClickListener {
            if(temail.text.isNotEmpty() && contra.text.isNotEmpty()){

                FirebaseAuth.getInstance().signInWithEmailAndPassword(temail.text.toString(),
                    contra.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this,HomeActivity::class.java)
                        startActivity(intent)
                    }else{
                        showAlert()
                    }
                }
            }
        }
        bAbout.setOnClickListener { showAboutDialog() }

    }


   */
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
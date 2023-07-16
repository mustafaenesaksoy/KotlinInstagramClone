package com.enesaksoy.kotlininstagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.enesaksoy.kotlininstagramclone.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser != null){
            val intent = Intent(this,FeedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun signIn(view : View){

        val email = binding.emailText.text.toString()
        val pasword = binding.passwordText.text.toString()
        if(email.equals("") || pasword.equals("")){
            Toast.makeText(this,"email ve parola alanı boş bırakılamaz.",Toast.LENGTH_SHORT).show()
        }else{
            auth.signInWithEmailAndPassword(email,pasword).addOnSuccessListener {
                val intent = Intent(this,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun signUP(view : View){

        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()
        if(email.equals("") || password.equals("")){
            Toast.makeText(this,"email ve parola alanı boş bırakılamaz.",Toast.LENGTH_SHORT).show()
        }else{
            auth.createUserWithEmailAndPassword(email,password).addOnFailureListener {
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                val intent = Intent(this,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
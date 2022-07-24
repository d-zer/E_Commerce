package com.dozer.ecommerceapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class SignupActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivitySignupBinding

    private val userCollectionReference = Firebase.firestore.collection("Users")
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_signup)

        tasarim.buttonSignup.setOnClickListener {
            /*
            val database = FirebaseDatabase.getInstance()
            val refKisiler = database.getReference("kisiler")
            var name = tasarim.editTextSignupName.toString()
            var email = tasarim.editTextSignupEmail.toString()
            var password = tasarim.editTextSignupPassword.toString()
            val kisi = Kisiler(name,email,password)
            refKisiler.push().setValue(kisi)
            */
            val mainIntent = Intent(this@SignupActivity,MainActivity::class.java)
            finish()
            startActivity(mainIntent)
        }

        tasarim.textViewtoLogin.setOnClickListener {
            val loginIntent = Intent(this@SignupActivity,LoginActivity::class.java)
            finish()
            startActivity(loginIntent)
        }
    }

    override fun onBackPressed() {
        val yeniIntent = Intent(Intent.ACTION_MAIN)

        yeniIntent.addCategory(Intent.CATEGORY_HOME)
        yeniIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(yeniIntent)
    }

    private fun textCheck() {
        tasarim.editTextSignupName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                if (tasarim.editTextSignupName.text.isEmpty()) {
                    tasarim.editTextSignupName.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
                }
                else if (tasarim.editTextSignupName.text.length >= 4) {
                    tasarim.editTextSignupName.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check), null)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                tasarim.editTextSignupName.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count >= 4) {
                    tasarim.editTextSignupName.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check),null)
                }
            }
        })

        tasarim.editTextSignupEmail.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                if (tasarim.editTextSignupEmail.text.isEmpty()) {
                    tasarim.editTextSignupEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
                }
                else if (tasarim.editTextSignupEmail.text.matches(emailPattern.toRegex())) {
                    tasarim.editTextSignupEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check),null)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                tasarim.editTextSignupEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (tasarim.editTextSignupEmail.text.matches(emailPattern.toRegex())) {
                    tasarim.editTextSignupEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check),null)
                }
            }
        })

        tasarim.editTextSignupPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (tasarim.editTextSignupPassword.text.isEmpty()) {
                    tasarim.editTextSignupPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
                }
                else if (tasarim.editTextSignupPassword.text.length >= 5){
                    tasarim.editTextSignupPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check), null)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                tasarim.editTextSignupPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count >= 5) {
                    tasarim.editTextSignupPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check), null)
                }
            }

        })

    }

    private fun inputCheck() {
        if (tasarim.editTextSignupName.text.isEmpty()) {
            Toast.makeText(applicationContext,"Not a valid name. It's empty!",Toast.LENGTH_SHORT).show()
        }
        if (tasarim.editTextSignupEmail.text.isEmpty()) {
            Toast.makeText(applicationContext,"Not a valid email address. It's empty!",Toast.LENGTH_SHORT).show()
        }
        if (tasarim.editTextSignupPassword.text.isEmpty()) {
            Toast.makeText(applicationContext,"Not a valid password. It's empty!",Toast.LENGTH_SHORT).show()
        }
        if (!tasarim.editTextSignupEmail.text.matches(emailPattern.toRegex())) {
            Toast.makeText(applicationContext,"Not a valid email address. Should be your@email.com",Toast.LENGTH_SHORT).show()
        }
        signIn()
    }

    private fun signIn() {
        val name: String = tasarim.editTextSignupName.text.toString()
        val email: String = tasarim.editTextSignupEmail.text.toString()
        val password: String = tasarim.editTextSignupPassword.text.toString()
        /*
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = User(name,"",firebaseAuth.uid.toString(),email,"","")

                }
            }

         */
    }

}
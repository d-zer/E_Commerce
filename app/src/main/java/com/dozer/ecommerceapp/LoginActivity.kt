package com.dozer.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivityLoginBinding
import com.dozer.ecommerceapp.FirebaseUtil
import com.dozer.ecommerceapp.FirebaseUtil.firebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var tasarim:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_login)

        textCheckLogin()

        tasarim.textViewSignupTransfer.setOnClickListener {
            val signupIntent = Intent(this@LoginActivity,SignupActivity::class.java)
            finish()
            startActivity(signupIntent)
        }

        tasarim.textViewtoForgotPassword.setOnClickListener {
            val forgotIntent = Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
            startActivity(forgotIntent)
        }

        tasarim.buttonLogin.setOnClickListener {
            inputCheckLogin()
        }

    }

    private fun textCheckLogin() {

        tasarim.editTextLoginEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                tasarim.editTextLoginEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(Patterns.EMAIL_ADDRESS.matcher(tasarim.editTextLoginEmail.text).matches()) {
                    tasarim.editTextLoginPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check),null)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (tasarim.editTextLoginEmail.text.isEmpty()) {
                    tasarim.editTextLoginEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check_incorrect),null)
                } else if (Patterns.EMAIL_ADDRESS.matcher(tasarim.editTextLoginEmail.text).matches()) {
                    tasarim.editTextLoginEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check),null)
                }
            }

        })

        tasarim.editTextLoginPassword.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                tasarim.editTextLoginPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (tasarim.editTextLoginPassword.text.length > 4) {
                    tasarim.editTextLoginPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check),null)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (tasarim.editTextLoginPassword.text.isEmpty()) {
                    tasarim.editTextLoginPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check_incorrect),null)
                } else if (tasarim.editTextLoginPassword.text.length > 4) {
                    tasarim.editTextLoginPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,ContextCompat.getDrawable(applicationContext,R.drawable.ic_check),null)
                }
            }

        })
    }

    private fun inputCheckLogin() {

        if (tasarim.editTextLoginEmail.text.isEmpty()) {
            Toast.makeText(applicationContext,"Not a valid email address. It's empty!",Toast.LENGTH_SHORT).show()
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(tasarim.editTextLoginEmail.text).matches()) {
            Toast.makeText(applicationContext,"Not a valid email address. Should be your@email.com",Toast.LENGTH_SHORT).show()
        }
        if (tasarim.editTextLoginPassword.text.isEmpty()) {
            Toast.makeText(applicationContext,"Not a valid password. It's empty!",Toast.LENGTH_SHORT).show()
        }
        if (tasarim.editTextLoginEmail.text.isNotEmpty() && tasarim.editTextLoginPassword.text.isNotEmpty()) {
            loginUser()
        }

    }

    private fun loginUser() {

        firebaseAuth.signInWithEmailAndPassword(tasarim.editTextLoginEmail.text.toString(),tasarim.editTextLoginPassword.text.toString())
            .addOnCompleteListener { login ->
                if (login.isSuccessful) {

                    var currentUser = FirebaseUtil.firebaseAuth.currentUser

                    if (currentUser!!.isEmailVerified()) {
                        val mainIntent = Intent(this@LoginActivity,MainActivity::class.java)
                        finish()
                        startActivity(mainIntent)
                    } else {
                        currentUser.sendEmailVerification()
                        Toast.makeText(applicationContext,"Check your email to verify your account!",Toast.LENGTH_LONG).show()
                    }

                } else {
                    Toast.makeText(applicationContext,"Login Failed",Toast.LENGTH_LONG).show()
                }
            }
    }

    override fun onBackPressed() {
        val yeniIntent = Intent(Intent.ACTION_MAIN)

        yeniIntent.addCategory(Intent.CATEGORY_HOME)
        yeniIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(yeniIntent)
    }
}
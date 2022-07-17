package com.dozer.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var tasarim:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_login)

        /*email pattern
        Toast.makeText(this@LoginActivity,"Not a valid email address. Should be your@email.com",Toast.LENGTH_SHORT).show()
        */

        tasarim.buttonLogin.setOnClickListener {
            val mainIntent = Intent(this@LoginActivity,MainActivity::class.java)
            finish()
            startActivity(mainIntent)
        }

        tasarim.textViewSignupTransfer.setOnClickListener {
            val signupIntent = Intent(this@LoginActivity,SignupActivity::class.java)
            finish()
            startActivity(signupIntent)
        }

        tasarim.textViewtoForgotPassword.setOnClickListener {
            val forgotIntent = Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
            startActivity(forgotIntent)
        }

    }

    override fun onBackPressed() {
        val yeniIntent = Intent(Intent.ACTION_MAIN)

        yeniIntent.addCategory(Intent.CATEGORY_HOME)
        yeniIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(yeniIntent)
    }
}
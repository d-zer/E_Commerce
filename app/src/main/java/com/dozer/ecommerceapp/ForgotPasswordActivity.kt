package com.dozer.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivityForgotPasswordBinding
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_forgot_password)

        tasarim.buttonEmailSend.setOnClickListener {
            resetPassword()
        }
    }

    private fun resetPassword() {

        if (tasarim.editTextForgotEmail.text.isEmpty()) {
            Toast.makeText(applicationContext,"Not a valid email address. It's empty!",Toast.LENGTH_LONG).show()
        }
        if (Patterns.EMAIL_ADDRESS.matcher(tasarim.editTextForgotEmail.text).matches()) {
            Toast.makeText(applicationContext,"Not a valid email address. Should be your@email.com",Toast.LENGTH_LONG).show()
        }

        tasarim.progressBarForgotPassword.setTransitionVisibility(View.VISIBLE)
        firebaseAuth.sendPasswordResetEmail(tasarim.editTextForgotEmail.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext,"Check your email to reset your password!",Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext,"Try again! Something wrong happened!",Toast.LENGTH_LONG).show()
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
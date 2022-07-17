package com.dozer.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_forgot_password)

        /*email pattern
        Toast.makeText(this@ForgotPasswordActivity,"Not a valid email address. Should be your@email.com",Toast.LENGTH_SHORT).show()
        */
    }

    override fun onBackPressed() {
        val yeniIntent = Intent(Intent.ACTION_MAIN)

        yeniIntent.addCategory(Intent.CATEGORY_HOME)
        yeniIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(yeniIntent)
    }
}
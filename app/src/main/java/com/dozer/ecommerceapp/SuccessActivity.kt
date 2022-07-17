package com.dozer.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_success)

        tasarim.buttontoShop.setOnClickListener {
            val mainIntent = Intent(this@SuccessActivity,MainActivity::class.java)
            startActivity(mainIntent)
        }
    }

    override fun onBackPressed() {
        val backIntent = Intent(this@SuccessActivity,MainActivity::class.java)
        backIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(backIntent)
    }
}
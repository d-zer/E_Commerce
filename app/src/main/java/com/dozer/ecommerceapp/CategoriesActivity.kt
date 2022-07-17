package com.dozer.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_categories)

        tasarim.buttontoMain.setOnClickListener {
            val mainIntent = Intent(this@CategoriesActivity,MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
}
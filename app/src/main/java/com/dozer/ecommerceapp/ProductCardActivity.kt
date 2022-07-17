package com.dozer.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivityProductCardBinding

class ProductCardActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivityProductCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_product_card)

        tasarim.buttontoBag.setOnClickListener {
            val bagIntent = Intent(this@ProductCardActivity,MyBagActivity::class.java)
            startActivity(bagIntent)
        }
    }
}
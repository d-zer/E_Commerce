package com.dozer.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivityMyBagBinding

class MyBagActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivityMyBagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_my_bag)

        tasarim.buttonCheckBag.setOnClickListener {
            val successIntent = Intent(this@MyBagActivity,SuccessActivity::class.java)
            startActivity(successIntent)
        }
    }

}
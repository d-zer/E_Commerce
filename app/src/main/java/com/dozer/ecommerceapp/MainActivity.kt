package com.dozer.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.dozer.ecommerceapp.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var tasarim:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_main)

        /*
        tasarim.buttonSaleCheck.setOnClickListener {
            val saleIntent = Intent(this@MainActivity,SaleProductsActivity::class.java)
            startActivity(saleIntent)
        }
        */

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        NavigationUI.setupWithNavController(tasarim.bottomNavigation,navHostFragment.navController)


    }
}
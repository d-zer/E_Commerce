package com.dozer.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dozer.ecommerceapp.databinding.ActivitySaleProductsBinding

class SaleProductsActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivitySaleProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_sale_products)
    }
}
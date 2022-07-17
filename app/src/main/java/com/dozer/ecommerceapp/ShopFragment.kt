package com.dozer.ecommerceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ShopFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarimShop = inflater.inflate(R.layout.fragment_shop, container, false)
        return tasarimShop
    }

}
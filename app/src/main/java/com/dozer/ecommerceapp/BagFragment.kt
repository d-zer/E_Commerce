package com.dozer.ecommerceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BagFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarimBag = inflater.inflate(R.layout.fragment_bag, container, false)
        return tasarimBag
    }

}
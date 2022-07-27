package com.dozer.ecommerceapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    private lateinit var database: DatabaseReference

    val userName: String = textViewUserName.text.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarimProfile = inflater.inflate(R.layout.fragment_profile, container, false)

        readData(userName)

        buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            val profileIntent = Intent(this@ProfileFragment.context,LoginActivity::class.java)
            startActivity(profileIntent)
        }

        return tasarimProfile
    }

    // eksik var
    private fun readData(userName: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(userName).get().addOnSuccessListener {

            if (it.exists()) {

                val id = it.child("id").value
                val name = it.child("name").value
                val email = it.child("email").value



            } else {
                Toast.makeText(this@ProfileFragment.context,"User Doesn't Exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this@ProfileFragment.context,"Failed",Toast.LENGTH_SHORT).show()
        }
    }


}
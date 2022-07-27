package com.dozer.ecommerceapp

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

object FirebaseUtil {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val firebaseUser: FirebaseUser? = firebaseAuth.currentUser
    val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
}
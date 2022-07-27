package com.dozer.ecommerceapp
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(val userName: String = "", val userEmail: String = "", val userPassword: String = "") {

}
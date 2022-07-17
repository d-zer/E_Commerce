package com.dozer.ecommerceapp

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Kisiler(var name:String? = "", var email:String? = "", var password:String? = "") {



}
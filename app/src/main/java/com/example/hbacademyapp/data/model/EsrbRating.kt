package com.example.hbacademyapp.data.model

import com.google.gson.annotations.SerializedName


data class EsrbRating (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("slug" ) var slug : String? = null,
  @SerializedName("name" ) var name : String? = null

)
package com.example.hbacademyapp.data.model

import com.google.gson.annotations.SerializedName


data class Requirements (

  @SerializedName("minimum"     ) var minimum     : String? = null,
  @SerializedName("recommended" ) var recommended : String? = null

)
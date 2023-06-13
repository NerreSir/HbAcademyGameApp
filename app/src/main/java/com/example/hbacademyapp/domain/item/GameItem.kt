package com.example.hbacademyapp.domain.item

import com.example.hbacademyapp.data.model.GameModel

data class GameItem(

    val id : Int,
    val title: String,
    val thumbnail: String,
    val short_description: String

)

fun GameModel.toGameItem() = GameItem(id, title, thumbnail, short_description)

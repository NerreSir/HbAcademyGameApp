package com.example.hbacademyapp.data

import com.example.hbacademyapp.data.model.GameResponseModel
import retrofit2.http.GET

interface GameApi {

    @GET("games")
    suspend fun getGames(): GameResponseModel

}
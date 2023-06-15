package com.example.hbacademyapp.data

import com.example.hbacademyapp.data.model.GameDetailModel
import com.example.hbacademyapp.data.model.GameResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApi {

    @GET("games")
    suspend fun getGames(): GameResponseModel

    @GET("games/{id}")
    suspend fun getGameDetail(@Path("id") id:Int): GameDetailModel

}
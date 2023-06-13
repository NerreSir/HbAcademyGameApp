package com.example.hbacademyapp.data

import com.example.hbacademyapp.data.model.GameModel
import com.example.hbacademyapp.util.Constants.Companion.GAMES_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface GameApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>

}
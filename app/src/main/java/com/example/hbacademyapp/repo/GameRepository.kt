package com.example.hbacademyapp.repo

import com.example.hbacademyapp.data.GameApi
import com.example.hbacademyapp.data.model.GameDetailModel
import com.example.hbacademyapp.data.model.GameModel
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameApi: GameApi) {

    suspend fun getGames(): List<GameModel> {
        return gameApi.getGames().results
    }

    suspend fun getGameDetail(id: Int): GameDetailModel {
        return gameApi.getGameDetail(id)
    }
}

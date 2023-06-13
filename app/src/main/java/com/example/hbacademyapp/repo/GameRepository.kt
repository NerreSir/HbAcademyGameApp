package com.example.hbacademyapp.repo

import com.example.hbacademyapp.data.GameService
import com.example.hbacademyapp.domain.item.GameItem
import com.example.hbacademyapp.domain.item.toGameItem
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameService: GameService) {

    suspend fun getGames(): List<GameItem> {
        return gameService.getGames().map {
            it.toGameItem()
        }
    }
}
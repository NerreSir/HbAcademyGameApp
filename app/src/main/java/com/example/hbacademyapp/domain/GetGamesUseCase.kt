package com.example.hbacademyapp.domain

import com.example.hbacademyapp.domain.item.GameItem
import com.example.hbacademyapp.repo.GameRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(): List<GameItem> {
        return gameRepository.getGames()//.shuffled()
    }

}
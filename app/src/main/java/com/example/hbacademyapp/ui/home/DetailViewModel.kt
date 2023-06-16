package com.example.hbacademyapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hbacademyapp.data.model.GameDetailModel
import com.example.hbacademyapp.repo.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val gameRepository: GameRepository
) : ViewModel() {

    private val _gameDetail = MutableStateFlow(GameDetailModel())
    var gameDetail: StateFlow<GameDetailModel> = _gameDetail

    init {
        //_gameId.value?.let { getGameDetail(it) }
    }

    fun getGameDetail(id: Int) {
        viewModelScope.launch {
            _gameDetail.emit(gameRepository.getGameDetail(id))
        }
    }

}
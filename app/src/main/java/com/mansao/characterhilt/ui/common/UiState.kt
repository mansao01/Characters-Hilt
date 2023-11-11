package com.mansao.characterhilt.ui.common

import com.mansao.characterhilt.data.local.model.CharacterModel
import com.mansao.characterhilt.data.remote.response.GetAllCharactersResponseItem

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Error(val message: String) : HomeUiState

    data class Success(val data: List<GetAllCharactersResponseItem>) : HomeUiState

}

sealed interface FavoriteUiState {
    data class Result(val characters: List<CharacterModel> = listOf()) : FavoriteUiState
}
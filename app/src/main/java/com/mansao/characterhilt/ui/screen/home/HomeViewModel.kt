package com.mansao.characterhilt.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mansao.characterhilt.data.CharacterRepository
import com.mansao.characterhilt.data.local.model.CharacterModel
import com.mansao.characterhilt.ui.common.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    var uiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        viewModelScope.launch {
            uiState = HomeUiState.Loading
            uiState = try {
                val result = characterRepository.getCharacters()
                HomeUiState.Success(result)
            } catch (e: Exception) {
                HomeUiState.Error(e.message.toString())
            }
        }
    }

    fun insertToFavorite(characterModel: CharacterModel) {
        viewModelScope.launch {
             try {
                characterRepository.insertFavorite(characterModel)
            } catch (e: Exception) {
                HomeUiState.Error(e.message.toString())
            }
        }
    }


}
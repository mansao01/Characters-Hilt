package com.mansao.characterhilt.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mansao.characterhilt.data.CharacterRepository
import com.mansao.characterhilt.ui.common.FavoriteUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val uiState: StateFlow<FavoriteUiState.Result> =
        characterRepository.getFavoriteCharacters().map { FavoriteUiState.Result(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = FavoriteUiState.Result()
            )
}
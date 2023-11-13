package com.mansao.characterhilt.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.ui.graphics.vector.ImageVector
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

sealed interface SettingUiState {
    data class SettingUiState(
        val isDarkMode: Boolean = false,
        val title: String = if (isDarkMode) "Dark Mode" else "Light Mode",
        val icon: ImageVector =
            if (isDarkMode) Icons.Default.DarkMode else Icons.Default.LightMode
    )

}
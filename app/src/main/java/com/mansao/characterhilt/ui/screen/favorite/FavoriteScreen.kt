package com.mansao.characterhilt.ui.screen.favorite

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.mansao.characterhilt.data.local.model.CharacterModel
import com.mansao.characterhilt.ui.components.FavoriteCharacterItem

@Composable
fun FavoriteScreen(
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
) {
    val uiState by favoriteViewModel.uiState.collectAsState()

    FavoriteList(character = uiState.characters)
}

@Composable
fun FavoriteList(
    character: List<CharacterModel>
) {
    LazyColumn {
        items(character) { data ->
            FavoriteCharacterItem(character = data)
        }
    }
}
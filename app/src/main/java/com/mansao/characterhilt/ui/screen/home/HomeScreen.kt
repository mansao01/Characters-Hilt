package com.mansao.characterhilt.ui.screen.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.mansao.characterhilt.data.remote.response.GetAllCharactersResponseItem
import com.mansao.characterhilt.ui.common.HomeUiState
import com.mansao.characterhilt.ui.components.CharacterItem

@Composable
fun HomeScreen(
    uiState: HomeUiState
) {
    val context = LocalContext.current
    when (uiState) {
        is HomeUiState.Loading -> {}
        is HomeUiState.Success -> HomeContent(character = uiState.data)
        is HomeUiState.Error -> {
            Log.d("Error", uiState.message)
            Toast.makeText(context, uiState.message, Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun HomeContent(
    character:List<GetAllCharactersResponseItem>
) {
    LazyColumn{
        items(character){data ->
            CharacterItem(character = data)
        }
    }
}
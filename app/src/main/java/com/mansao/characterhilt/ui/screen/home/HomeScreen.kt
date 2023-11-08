package com.mansao.characterhilt.ui.screen.home

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.mansao.characterhilt.ui.common.HomeUiState

@Composable
fun HomeScreen(
    uiState: HomeUiState
) {
    val context = LocalContext.current
    when (uiState) {
        is HomeUiState.Loading -> {}
        is HomeUiState.Success -> Log.d("HomeScreen", uiState.data.toString())
        is HomeUiState.Error -> Log.d("Error", uiState.message.toString())
    }
}
package com.mansao.characterhilt.ui.screen.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.mansao.characterhilt.data.local.model.CharacterModel
import com.mansao.characterhilt.data.remote.response.GetAllCharactersResponseItem
import com.mansao.characterhilt.ui.common.HomeUiState
import com.mansao.characterhilt.ui.components.CharacterItem

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigateToFavorite: () -> Unit
) {
    val context = LocalContext.current
    when (uiState) {
        is HomeUiState.Loading -> {}
        is HomeUiState.Success -> HomeContent(
            character = uiState.data,
            homeViewModel = homeViewModel,
            navigateToFavorite = navigateToFavorite
        )

        is HomeUiState.Error -> {
            Log.d("Error", uiState.message)
            Toast.makeText(context, uiState.message, Toast.LENGTH_SHORT).show()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    character: List<GetAllCharactersResponseItem>,
    homeViewModel: HomeViewModel,
    navigateToFavorite: () -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        topBar = { HomeTopBar(navigateToFavorite = navigateToFavorite) }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            LazyColumn {
                items(character) { data ->
                    CharacterItem(character = data, modifier = Modifier.clickable {
                        homeViewModel.insertToFavorite(
                            CharacterModel(
                                data.id,
                                data.name,
                                data.image
                            )
                        )
                        Toast.makeText(context, "Added to favorite", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun HomeTopBar(
    navigateToFavorite: () -> Unit
) {
    TopAppBar(title = { Text(text = "Home") },
        actions = {
            IconButton(onClick = { navigateToFavorite() }) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "favorite")
            }
        })
}
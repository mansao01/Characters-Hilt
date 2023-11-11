package com.mansao.characterhilt.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mansao.characterhilt.ui.navigation.Screen
import com.mansao.characterhilt.ui.screen.favorite.FavoriteScreen
import com.mansao.characterhilt.ui.screen.home.HomeScreen
import com.mansao.characterhilt.ui.screen.home.HomeViewModel

@Composable
fun CharacterApp(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                uiState = homeViewModel.uiState,
                navigateToFavorite = {
                    navHostController.navigate(Screen.Favorite.route)
                }
            )
        }

        composable(Screen.Favorite.route) {
            FavoriteScreen()
        }
    }
}
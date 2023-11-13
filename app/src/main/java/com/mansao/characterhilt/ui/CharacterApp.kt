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
import com.mansao.characterhilt.ui.screen.setting.SettingScreen

@Composable
fun CharacterApp(
    navHostController: NavHostController = rememberNavController(),
    onDarkModeChanged: (Boolean) -> Unit

) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                uiState = homeViewModel.uiState,
                navigateToFavorite = {
                    navHostController.navigate(Screen.Favorite.route)
                },
                navigateToSetting = {
                    navHostController.navigate(Screen.Setting.route)
                }
            )
        }

        composable(Screen.Favorite.route) {
            FavoriteScreen()
        }

        composable(Screen.Setting.route) {
            SettingScreen(onDarkModeChanged = onDarkModeChanged)
        }
    }
}
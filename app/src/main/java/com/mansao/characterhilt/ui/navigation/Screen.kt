package com.mansao.characterhilt.ui.navigation

sealed class Screen(val route:String){
    object Home:Screen("home")
    object Favorite:Screen("favorite")

}

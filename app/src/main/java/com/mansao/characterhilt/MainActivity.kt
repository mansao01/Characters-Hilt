package com.mansao.characterhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mansao.characterhilt.ui.CharacterApp
import com.mansao.characterhilt.ui.screen.setting.SettingVIewModel
import com.mansao.characterhilt.ui.theme.CharacterHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val settingVIewModel: SettingVIewModel = hiltViewModel()
            var isDarkMode = settingVIewModel.isDarkMode.collectAsState().value.isDarkMode

            CharacterHiltTheme(isDarkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CharacterApp(
                        onDarkModeChanged = { newDarkMode ->
                            isDarkMode = newDarkMode
                        }
                    )
                }
            }
        }
    }
}

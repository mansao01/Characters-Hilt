package com.mansao.characterhilt.ui.screen.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingScreen(
    settingViewModel: SettingVIewModel = hiltViewModel(),
    onDarkModeChanged: (Boolean) -> Unit
) {
    SettingContent(settingViewModel = settingViewModel, onDarkModeChanged = onDarkModeChanged)

}

@Composable
fun SettingContent(
    modifier: Modifier = Modifier,
    settingViewModel: SettingVIewModel,
    onDarkModeChanged: (Boolean) -> Unit
) {
    val isDarkMode by settingViewModel.isDarkMode.collectAsState()

    val icon: (@Composable () -> Unit) = {
        Icon(
            imageVector = isDarkMode.icon,
            contentDescription = null,
            modifier = Modifier.size(SwitchDefaults.IconSize)
        )
    }
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = isDarkMode.title, modifier = Modifier.padding(top = 4.dp), fontSize = 20.sp)
        Switch(
            checked = isDarkMode.isDarkMode,
            onCheckedChange = { isChecked ->
                settingViewModel.selectedTheme(isChecked)
                onDarkModeChanged(isChecked)
            },
            thumbContent = icon,
        )
    }
}
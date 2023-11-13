package com.mansao.characterhilt.ui.screen.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mansao.characterhilt.data.preferences.SettingPreferences
import com.mansao.characterhilt.ui.common.SettingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingVIewModel @Inject constructor(private val settingPreferences: SettingPreferences) :
    ViewModel() {
    val isDarkMode = settingPreferences.isDarkMode.map { isDarkMode ->
        SettingUiState.SettingUiState(isDarkMode)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = SettingUiState.SettingUiState()
    )
    val uiState: StateFlow<SettingUiState.SettingUiState> = isDarkMode

    fun selectedTheme(isDarkMode: Boolean) {
        viewModelScope.launch {
            settingPreferences.saveThemePreferences(isDarkMode)
        }
    }
}
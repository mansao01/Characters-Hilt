package com.mansao.characterhilt.data.preferences

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "setting")

class SettingPreferences @Inject constructor(@ApplicationContext val context: Context) {
    private val dataStore = context.dataStore

    val isDarkMode: Flow<Boolean> = dataStore.data
        .catch {
            if (it is IOException) {
                Log.e(TAG, "Error reading preferences", it)
                emit(emptyPreferences())
            } else throw it
        }.map { preferences ->
            preferences[IS_DARK_MODE] ?: true

        }

    suspend fun saveThemePreferences(isDarkMode: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_DARK_MODE] = isDarkMode
        }
    }

    private companion object {
        val IS_DARK_MODE = booleanPreferencesKey("is_dark_mode")
        const val TAG = "ProfilePreferencesRepo"
    }
}
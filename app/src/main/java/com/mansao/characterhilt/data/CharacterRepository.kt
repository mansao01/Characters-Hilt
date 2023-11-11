package com.mansao.characterhilt.data

import com.mansao.characterhilt.data.local.CharacterDatabase
import com.mansao.characterhilt.data.local.model.CharacterModel
import com.mansao.characterhilt.data.remote.ApiService
import com.mansao.characterhilt.data.remote.response.GetAllCharactersResponseItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: ApiService,
    private val characterDatabase: CharacterDatabase
) {
    suspend fun getCharacters(): List<GetAllCharactersResponseItem> {
        return apiService.getAllCharacters()
    }

    suspend fun insertFavorite(characterModel: CharacterModel) {
        return characterDatabase.characterDao().insert(characterModel)
    }

    suspend fun deleteFavorite(characterModel: CharacterModel) {
        return characterDatabase.characterDao().delete(characterModel)
    }

    fun getFavoriteCharacters(): Flow<List<CharacterModel>> {
        return characterDatabase.characterDao().getAllCharacters()
    }


}
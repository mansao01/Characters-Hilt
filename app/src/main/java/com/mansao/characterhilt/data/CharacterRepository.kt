package com.mansao.characterhilt.data

import com.mansao.characterhilt.data.remote.ApiService
import com.mansao.characterhilt.data.remote.response.GetAllCharactersResponseItem
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCharacters():List<GetAllCharactersResponseItem>{
        return apiService.getAllCharacters()
    }
}
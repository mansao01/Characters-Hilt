package com.mansao.characterhilt.data.remote

import com.mansao.characterhilt.data.remote.response.GetAllCharactersResponse
import com.mansao.characterhilt.data.remote.response.GetAllCharactersResponseItem
import retrofit2.http.GET

interface ApiService {

    @GET(ApiConst.GET_ALL_CHARS_ENDPOINT)
    suspend fun getAllCharacters():List<GetAllCharactersResponseItem>
}
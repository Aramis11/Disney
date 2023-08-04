package com.edw.data.api

import com.edw.data.api.character.CharacterDTO
import com.edw.data.api.characterDetail.CharacterDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {
    @GET("character")
    suspend fun getCharacter(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): CharacterDTO

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterDetailDTO
}


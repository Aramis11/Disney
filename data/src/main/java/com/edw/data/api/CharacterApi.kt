package com.edw.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {
    @GET("character")
    suspend fun getCharacter(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): CharacterDTO

    companion object {
        const val BASE_URL = "https://api.disneyapi.dev/"
    }
}


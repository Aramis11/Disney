package com.edw.data.api.characterDetail

import com.google.gson.annotations.SerializedName

data class CharacterDetailDTO(
    @SerializedName("data")  val data: CharacterDetailInfoDTO
)

data class CharacterDetailInfoDTO(
    @SerializedName("_id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("films") val films: List<String>,
    @SerializedName("tvShows") val tvShows: List<String>,
    @SerializedName("videoGames") val videoGames: List<String>,
    @SerializedName("enemies") val enemies: List<String>,
    @SerializedName("allies") val allies: List<String>,
    @SerializedName("imageUrl") val imageUrl: String
)
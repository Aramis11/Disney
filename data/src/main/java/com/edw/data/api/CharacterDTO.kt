package com.edw.data.api

import com.google.gson.annotations.SerializedName


data class CharacterDTO(
    @SerializedName("data")  val character: List<CharacterInfoDTO>
)

data class CharacterInfoDTO(
    @SerializedName("_id") val id: Int,
    @SerializedName("sourceUrl") val sourceUrl: String,
    @SerializedName("name") val name: String,
    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("createdAt") val created: String,
    @SerializedName("updatedAt") val updated: String,
    @SerializedName("url") val url: String
)





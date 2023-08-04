package com.edw.data.domain

data class CharacterInfo(
    val id: Int,
    val sourceUrl: String,
    val name: String,
    val imageUrl: String?,
    val created: String,
    val updated: String,
    val url: String
)
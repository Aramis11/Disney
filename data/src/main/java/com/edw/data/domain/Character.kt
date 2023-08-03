package com.edw.data.domain

data class Character(val data: List<CharacterInfo>)

data class CharacterInfo(
    val _id: Int,
    val sourceUrl: String,
    val name: String,
    val imageUrl: String,
    val createdAt: String,
    val updatedAt: String,
    val url: String
)

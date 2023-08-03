package com.edw.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey
    val _id: Int,
    val sourceUrl: String,
    val name: String,
    val imageUrl: String,
    val createdAt: String,
    val updatedAt: String,
    val url: String
)

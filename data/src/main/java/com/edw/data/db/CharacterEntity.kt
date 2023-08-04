package com.edw.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val sourceUrl: String,
    val name: String,
    val imageUrl: String,
    val created: String,
    val updated: String,
    val url: String
)

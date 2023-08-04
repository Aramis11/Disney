package com.edw.data.domain

data class CharacterDetail(
    val id: Int,
    val name: String,
    val films: List<String>,
    val tvShows: List<String>,
    val videoGames: List<String>,
    val enemies: List<String>,
    val allies: List<String>,
    val imageUrl: String
)
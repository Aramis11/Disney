package com.edw.platzitechnical.ui.navigation

sealed class AppsScreens(val route: String) {
    object Characters : AppsScreens("character_screen")
    object CharactersDetail : AppsScreens("character_detail_screen")
}

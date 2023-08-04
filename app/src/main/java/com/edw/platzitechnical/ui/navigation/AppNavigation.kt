package com.edw.platzitechnical.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.compose.collectAsLazyPagingItems
import com.edw.platzitechnical.ui.screens.character.CharactersScreen
import com.edw.platzitechnical.ui.screens.characterdetail.CharacterDetailScreen
import com.edw.platzitechnical.viewmodel.CharacterDetailViewModel
import com.edw.platzitechnical.viewmodel.CharacterViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppsScreens.Characters.route) {
        composable(route = AppsScreens.Characters.route) {
            CharactersScreen(
                navController = navController,
                characters = hiltViewModel<CharacterViewModel>().characterPaging.collectAsLazyPagingItems(),
            )
        }
        composable(
            route = AppsScreens.CharactersDetail.route + "/{id}",
            arguments = listOf(navArgument(name = "id") {
                type = NavType.IntType
            })
        ) {
            CharacterDetailScreen(navController = navController, it.arguments?.getInt("id"))
        }
    }
}
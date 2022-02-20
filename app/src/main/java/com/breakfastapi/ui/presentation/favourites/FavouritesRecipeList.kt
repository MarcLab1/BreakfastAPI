package com.breakfastapi.ui.presentation

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.breakfastapi.ui.presentation.favourites.FavouriteRecipeContent
import com.breakfastapi.ui.presentation.favourites.FavouriteRecipeListAppBar
import com.breakfastapi.ui.presentation.favourites.FavouriteRecipeListViewModel

@Composable
fun FavouriteRecipeList(nav: NavController, vmFavouriteList: FavouriteRecipeListViewModel) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = { FavouriteRecipeListAppBar({ nav.navigateUp() }) },
        content = { FavouriteRecipeContent(nav, vmFavouriteList) },
        scaffoldState = scaffoldState,
        snackbarHost = {
            scaffoldState.snackbarHostState
        }
    )
}






package com.breakfastapi.ui.presentation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.breakfastapi.ui.presentation.recipelist.RecipeListAppBar
import com.breakfastapi.ui.presentation.recipelist.RecipeListContent
import com.breakfastapi.ui.presentation.recipelist.RecipeListViewModel
import com.breakfastapi.util.Routes

@Composable
fun RecipeList(nav: NavController, vmRecipeList: RecipeListViewModel) {

    val scaffoldState = rememberScaffoldState()

    Scaffold (
        topBar = { RecipeListAppBar({ nav.navigate(Routes.FAVOURITES.route) })},
        content = { RecipeListContent(nav,vmRecipeList)},
        scaffoldState = scaffoldState,
        snackbarHost = {scaffoldState.snackbarHostState}
    )
}



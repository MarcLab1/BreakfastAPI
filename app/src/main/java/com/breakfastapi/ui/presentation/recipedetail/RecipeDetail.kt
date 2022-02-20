package com.breakfastapi.ui.presentation

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.breakfastapi.model.Recipe
import com.breakfastapi.ui.presentation.favourites.FavouriteRecipeListViewModel

@Composable
fun RecipeDetail(
    recipe: Recipe,
    nav: NavController,
    vmFavouriteList: FavouriteRecipeListViewModel
) {
    val ctx = LocalContext.current
    var isFavourite = remember { mutableStateOf(vmFavouriteList.ifFavouriteRecipeExists(recipe))}
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            RecipeDetailAppBar(
                onClickNavigate = { nav.navigateUp() },
                onClickEmail = {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "message/rfc822"
                    intent.putExtra(Intent.EXTRA_SUBJECT, recipe.recipeName)
                    intent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Ingredients: ${recipe.ingredientsString}\n\nDirections: ${recipe.directionsString}"
                    )
                    try {
                        ctx.startActivity(Intent.createChooser(intent, "Email client"))
                    } catch (ex: ActivityNotFoundException) {
                        //todo later - handle some errors yo!
                    }
                },
                onClickFavourite = {
                    isFavourite.value = !isFavourite.value
                    vmFavouriteList.updateFavouriteRecipe(
                        recipe,
                        isFavourite.value,
                        scaffoldState
                    )
                },
                imageVector = if (isFavourite.value) Icons.Default.Favorite else Icons.Filled.FavoriteBorder
            )
        },
        content = {
            RecipeDetailContent(recipe)
        },
        scaffoldState = scaffoldState
    )
}

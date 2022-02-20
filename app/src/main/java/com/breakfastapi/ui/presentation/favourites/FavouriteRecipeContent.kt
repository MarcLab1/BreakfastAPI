package com.breakfastapi.ui.presentation.favourites

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.breakfastapi.ui.presentation.ListItem
import com.breakfastapi.util.Constants
import com.breakfastapi.util.Routes
import com.google.gson.Gson

@Composable
fun FavouriteRecipeContent(nav: NavController, vmFavouriteList: FavouriteRecipeListViewModel) {

    Box(modifier = Modifier.fillMaxSize())
    {

        LazyColumn() {
            itemsIndexed(vmFavouriteList.favouriteRecipes.value)
            { index, recipe ->
                ListItem(recipe, {
                    val jsonRecipe = Uri.encode(Gson().toJson(recipe))
                    nav.navigate("${Routes.RECIPE.route}/${jsonRecipe}")
                })
            }
        }

        if(vmFavouriteList.favouriteRecipes.value.size == 0)
        {
            Text(
                Constants.FAVOURITES_EMPTY_MSG, modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 10.dp, end = 10.dp))
        }
    }
}
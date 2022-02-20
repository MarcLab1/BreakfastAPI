package com.breakfastapi.ui.presentation.recipelist

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.breakfastapi.ui.presentation.ListItem
import com.breakfastapi.util.NetworkStatus
import com.breakfastapi.util.Routes
import com.google.gson.Gson

@Composable
fun RecipeListContent(nav: NavController, vmRecipeList: RecipeListViewModel)
{
    Box(modifier = Modifier.fillMaxSize())
    {
        LazyColumn() {

            itemsIndexed(vmRecipeList.recipes.value)
            { index, recipe ->
                ListItem(recipe, {

                    val jsonRecipe = Uri.encode(Gson().toJson(recipe))
                    nav.navigate("${Routes.RECIPE.route}/${jsonRecipe}")
                })

                if (((index + 1) >= vmRecipeList.recipes.value.size) && vmRecipeList.networkStatus.value == NetworkStatus.READY) {
                    vmRecipeList.loadRecipe()
                }
            }
        }
        if (vmRecipeList.networkStatus.value == NetworkStatus.LOADING)
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

        //also don't show if the network went down after a non-zero number of sucessful calls
        if (vmRecipeList.networkStatus.value == NetworkStatus.ERROR && vmRecipeList.recipes.value.size == 0)
            Text(
                vmRecipeList.networkStatus.value.msg,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 10.dp, end = 10.dp)
            )
    }
}
package com.breakfastapi.ui.presentation

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.breakfastapi.util.NetworkStatus
import com.breakfastapi.util.Routes
import com.google.gson.Gson

@Composable
fun RecipeList(nav: NavController) {
    var vm: RecipeViewModel = hiltViewModel()

    Box(modifier = Modifier.fillMaxSize())
    {
        LazyColumn() {

            itemsIndexed(vm.recipes.value)
            { index, recipe ->
                RecipeListItem(recipe, {
                    val jsonRecipe = Uri.encode(Gson().toJson(recipe))
                    nav.navigate("${Routes.RECIPE.route}/$jsonRecipe")
                })

                if (((index + 1) >= vm.recipes.value.size) && vm.networkStatus.value == NetworkStatus.READY) {
                    vm.loadRecipe()
                }
            }
        }
        if (vm.networkStatus.value == NetworkStatus.LOADING)
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

        //also don't show if the network went down after a non-zero number of sucessful calls
        if (vm.networkStatus.value == NetworkStatus.ERROR && vm.recipes.value.size == 0)
            Text(
                vm.networkStatus.value.msg,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 10.dp, end = 10.dp)
            )
    }
}
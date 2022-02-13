package com.breakfastapi.ui.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.breakfastapi.model.Recipe
import com.breakfastapi.util.AssetParamType
import com.breakfastapi.util.Routes

@Composable
fun Navigation()
{
    var nav = rememberNavController()
    NavHost(navController = nav, startDestination = Routes.HOME.route)
    {
        composable(Routes.HOME.route)
        {
            RecipeList(nav)
        }
        composable("${Routes.RECIPE.route}/{recipe}",
            arguments = listOf(navArgument("recipe") {
                type = AssetParamType()
            }))
        {
            val recipe = it.arguments?.getParcelable<Recipe>("recipe")
            if (recipe != null) {
               RecipeDetail(recipe, nav)
            }
        }
    }
}
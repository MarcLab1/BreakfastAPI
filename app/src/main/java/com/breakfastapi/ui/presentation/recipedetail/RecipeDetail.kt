package com.breakfastapi.ui.presentation

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.breakfastapi.model.Recipe

@Composable
fun RecipeDetail(recipe: Recipe, nav: NavController) {
    val ctx = LocalContext.current
    Scaffold(
        topBar = {
            RecipeDetailAppBar({ nav.navigateUp() },
                { val intent = Intent(Intent.ACTION_SEND)
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
            })
        },
        content = { RecipeDetailContent(recipe) }
    )
}

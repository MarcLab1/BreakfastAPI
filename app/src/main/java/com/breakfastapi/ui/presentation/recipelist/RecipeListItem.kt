package com.breakfastapi.ui.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.breakfastapi.model.Recipe
import com.breakfastapi.util.getFood

@Composable
fun RecipeListItem(recipe: Recipe, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = AbsoluteCutCornerShape(0.dp),
        border = BorderStroke(0.3.dp, color = Color.LightGray)
    ) {
        // Text(index.toString())
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp, bottom = 3.dp),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Column(
                horizontalAlignment = Alignment.Start, modifier = Modifier
                    .fillMaxSize(.80f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    var food = getFood(recipe.recipeName.lowercase())
                    Image(
                        painter = rememberImagePainter(food.imageInt),
                        contentDescription = food.imageName,
                        modifier = Modifier
                            .size(75.dp)
                            .padding(5.dp)
                    )
                    Column() {
                        Text(recipe.recipeName, style = MaterialTheme.typography.h1)
                        Text(recipe.ingredientsString, style = MaterialTheme.typography.body1)
                    }
                }
            }
            Column(modifier = Modifier.padding(start = 10.dp, end = 5.dp,), horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    "${recipe.cookTimeMinutes}",
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center
                )
                Text(
                    "minutes",
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}




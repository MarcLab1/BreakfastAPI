package com.breakfastapi.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.breakfastapi.R
import com.breakfastapi.model.Recipe
import com.breakfastapi.util.Constants
import com.breakfastapi.util.Helper.getListFromString
import com.breakfastapi.util.getFood

@Composable
fun RecipeDetailContent(recipe: Recipe) {
    LazyColumn(modifier = Modifier.padding(start = 10.dp, end = 10.dp))
    {
        item()
        {
            Column()
            {
                Row(modifier = Modifier.fillMaxWidth().padding(top=10.dp))
                {
                    Column(modifier = Modifier.fillMaxWidth(.7f)) {
                        Text(recipe.recipeName, style = MaterialTheme.typography.h6)
                    }
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            "id: ${recipe.id}",
                            style = MaterialTheme.typography.h1,
                            modifier = Modifier
                                .align(Alignment.End)
                        )
                    }
                }

                var food = getFood(recipe.recipeName.lowercase())
                Image(
                    painter = rememberImagePainter(
                        data = food.imageInt,
                        builder = { size(OriginalSize) },
                    ),
                    contentDescription = food.imageName,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Image(
                        painter = painterResource(R.drawable.ic_baseline_access_time_24),
                        contentDescription = "time", modifier = Modifier.padding(end = 3.dp)
                    )
                    Text("${recipe.cookTimeMinutes} mins", style = MaterialTheme.typography.h2)
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Text("Ingredients: ", style = MaterialTheme.typography.h3)
                Text(recipe.ingredientsString, style = MaterialTheme.typography.subtitle2)
                Spacer(modifier = Modifier.padding(5.dp))
                Text("Directions: ", style = MaterialTheme.typography.h3)
                var dirList = getListFromString(recipe.directionsString, Constants.PERIOD)
                dirList.forEachIndexed { index, direction ->
                    Row(modifier = Modifier.padding(bottom = 5.dp))
                    {
                        Text("${index+1}  ", style = MaterialTheme.typography.h3)
                        Text("$direction", style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}


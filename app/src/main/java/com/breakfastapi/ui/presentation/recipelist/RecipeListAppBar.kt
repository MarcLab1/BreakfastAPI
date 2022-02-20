package com.breakfastapi.ui.presentation.recipelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun RecipeListAppBar(onClickFavourite: () -> Unit) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        )
        {

            Text(
                "Recipes",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )

            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favourites",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                        onClickFavourite()
                    }
            )
        }
    }
}


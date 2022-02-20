package com.breakfastapi.ui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RecipeDetailAppBar(
    onClickNavigate: () -> Unit,
    onClickEmail: () -> Unit,
    onClickFavourite: () -> Unit,
    imageVector: ImageVector
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {
                        onClickNavigate()
                    }
            )
            Row()
            {

                Icon(
                    imageVector = imageVector,
                    contentDescription = "Favourite",
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable {
                            onClickFavourite()
                        }
                )
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Share",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .clickable {
                            onClickEmail()
                        }
                )
            }
        }
    }
}
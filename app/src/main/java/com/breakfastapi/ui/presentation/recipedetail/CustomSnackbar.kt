package com.breakfastapi.ui.presentation.recipedetail

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomSnackbar(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier
) {
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = modifier,
        snackbar = {
            Snackbar(
                action = { snackbarHostState.currentSnackbarData?.dismiss()  },
                content = { Text(it.message) })
        })
}
package com.breakfastapi.ui.presentation.favourites

import androidx.compose.material.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.breakfastapi.model.Recipe
import com.breakfastapi.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteRecipeListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var favouriteRecipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

    init {
        loadFavouriteRecipes()
    }

    fun loadFavouriteRecipes(): Unit {
        viewModelScope.launch {
            repository.getFavouriteRecipes().collect {
                favouriteRecipes.value = it
            }
        }
    }

    fun updateFavouriteRecipe(recipe: Recipe, isFavourite: Boolean, scaffoldState: ScaffoldState) {

        if (isFavourite)
            viewModelScope.launch {
                repository.insertFavouriteRecipe(recipe)
                scaffoldState.snackbarHostState.showSnackbar(
                    "Recipe added to favourites",
                    "Hide",
                    SnackbarDuration.Short
                )
            }
        else
            viewModelScope.launch {
                repository.deleteFavouriteRecipe(recipe)
                scaffoldState.snackbarHostState.showSnackbar(
                    "Recipe removed from favourites",
                    "Hide",
                    SnackbarDuration.Short
                )
            }
    }

    //I check against the list rather than querying the db
    fun ifFavouriteRecipeExists(recipe: Recipe): Boolean {
        if (favouriteRecipes.value.size != 0) {
            if (favouriteRecipes.value.contains(recipe))
                //if( favouriteRecipes.value.any{ r -> r.id == recipe.id }) {
                    return true
                }
        return false
    }


    //Used for internal testing
    private fun addFakeFavouriteRecipes() {
        for (i in 1..2000) {
            viewModelScope.launch {
                repository.insertFavouriteRecipe(
                    Recipe(
                        i.toLong(),
                        i.toString(),
                        i.toLong(),
                        "bling, blah, blah, blah",
                        "Cook the food.  Then eat the food."
                    )
                )
            }
        }
    }

}
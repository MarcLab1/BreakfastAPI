package com.breakfastapi.repository

import com.breakfastapi.model.Recipe
import com.breakfastapi.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getRecipe() : Resource<Recipe>

    fun getFavouriteRecipes() : Flow<List<Recipe>>
    suspend fun insertFavouriteRecipe(recipe: Recipe)
    suspend fun deleteFavouriteRecipe(recipe: Recipe)
}
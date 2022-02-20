package com.breakfastapi.repository

import com.breakfastapi.database.RecipeDatabase
import com.breakfastapi.model.Recipe
import com.breakfastapi.network.ApiService
import com.breakfastapi.network.toRecipe
import com.breakfastapi.util.Resource
import kotlinx.coroutines.flow.Flow

class Repository_Impl(
    private val apiService: ApiService,
    private val favouriteRecipeDatabase: RecipeDatabase
) : Repository {

    private val favouriteRecipeDao = favouriteRecipeDatabase.favouriteRecipeDao()

    override suspend fun getRecipe(): Resource<Recipe> {
        val response = try {
            apiService.getRecipe()
        } catch (ex: Exception) {
            return Resource.Error(ex)
        }
        return Resource.Success(response.recipe!!.toRecipe())
    }

    override fun getFavouriteRecipes(): Flow<List<Recipe>> {
        return favouriteRecipeDao.getFavouriteRecipes()
    }

    override suspend fun insertFavouriteRecipe(recipe: Recipe) {
        favouriteRecipeDao.insertFavouriteRecipe(recipe)
    }

    override suspend fun deleteFavouriteRecipe(recipe: Recipe) {
        return favouriteRecipeDao.deleteFavouriteRecipe(recipe)
    }
}
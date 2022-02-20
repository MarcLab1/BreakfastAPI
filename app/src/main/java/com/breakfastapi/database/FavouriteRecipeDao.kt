package com.breakfastapi.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.breakfastapi.model.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteRecipeDao {

    @Query("SELECT * FROM recipe")
    fun getFavouriteRecipes() : Flow<List<Recipe>>

    @Insert(onConflict = REPLACE)
    suspend fun insertFavouriteRecipe(recipe: Recipe)

    @Delete
    suspend fun deleteFavouriteRecipe(recipe: Recipe)

}
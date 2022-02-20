package com.breakfastapi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.breakfastapi.model.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun favouriteRecipeDao(): FavouriteRecipeDao
}
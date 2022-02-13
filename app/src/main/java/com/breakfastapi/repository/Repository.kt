package com.breakfastapi.repository

import com.breakfastapi.model.Recipe
import com.breakfastapi.util.Resource

interface Repository {

    suspend fun getRecipe() : Resource<Recipe>
}
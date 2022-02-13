package com.breakfastapi.repository

import com.breakfastapi.model.Recipe
import com.breakfastapi.network.ApiService
import com.breakfastapi.network.toRecipe
import com.breakfastapi.util.Resource

class Repository_Impl(private val apiService: ApiService) : Repository {
    override suspend fun getRecipe(): Resource<Recipe> {
        val response = try {
            apiService.getRecipe()
        } catch (ex: Exception) {
            return Resource.Error(ex)
        }
        return Resource.Success(response.toRecipe())
    }
}
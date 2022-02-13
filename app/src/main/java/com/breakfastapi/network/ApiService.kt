package com.breakfastapi.network

import retrofit2.http.GET

interface ApiService {

   @GET(".")
   suspend fun getRecipe() : RecipeDto

}
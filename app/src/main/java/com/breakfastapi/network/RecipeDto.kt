package com.breakfastapi.network

import com.breakfastapi.model.Recipe
import com.breakfastapi.util.Helper
import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val recipeName: String,

    @SerializedName("total_duration")
    val totalDuration: Long,

    @SerializedName("ingredients")
    val ingredients: List<String>,

    @SerializedName("directions")
    val directions: String
)

fun RecipeDto.toRecipe(): Recipe {
    return Recipe(
        id,
        recipeName,
        totalDuration,
        Helper.getStringFromList(ingredients),
        Helper.removeBrackets(directions)
    )
}


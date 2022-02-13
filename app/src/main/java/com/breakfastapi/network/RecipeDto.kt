package com.breakfastapi.network

import com.breakfastapi.model.Recipe
import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("ID")
    val id: Long,

    @SerializedName("Recipe Name")
    val recipeName: String,

    @SerializedName("Cook Time (Minutes)")
    val cookTimeMinutes: Long,

    @SerializedName("Ingredients")
    val ingredients: String,

    @SerializedName("Directions")
    val directions: String
)


fun RecipeDto.toRecipe(): Recipe {
    return Recipe(
        id,
        recipeName,
        cookTimeMinutes,
        //getListFromString(ingredients, Constants.COMMA),
        removeBrackets(ingredients),
        //getListFromString(directions, Constants.PERIOD),
        removeBrackets(directions)
    )
}

fun removeBrackets(input: String): String {
    return input.replace("'", "").replace("[", "").replace("]", "")
}
package com.breakfastapi.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: Long,
    val recipeName: String,
    val cookTimeMinutes: Long,
   // val ingredientsList: List<String>,
    val ingredientsString: String,
    //val directionsList: List<String>,
    val directionsString: String
) : Parcelable
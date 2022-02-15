package com.breakfastapi.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: Long,
    val recipeName: String,
    val totalDuration: Long,
    val ingredientsString: String,
    val directionsString: String
) : Parcelable
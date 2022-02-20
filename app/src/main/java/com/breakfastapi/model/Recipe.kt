package com.breakfastapi.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity (tableName = "recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val recipeName: String,
    val totalDuration: Long,
    val ingredientsString: String,
    val directionsString: String
) : Parcelable
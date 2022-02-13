package com.breakfastapi.util

import android.os.Bundle
import androidx.navigation.NavType
import com.breakfastapi.model.Recipe
import com.google.gson.Gson

class AssetParamType : NavType<Recipe>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Recipe? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Recipe {
        return Gson().fromJson(value, Recipe::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Recipe) {
        bundle.putParcelable(key, value)
    }
}
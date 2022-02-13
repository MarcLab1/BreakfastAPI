package com.breakfastapi.util

import com.breakfastapi.R

data class Food(val imageName: String, val imageInt: Int)

val foodList = listOf<Food>(
    Food("beef", R.drawable.beef),
    Food("bread", R.drawable.bread),
    Food("brisket", R.drawable.brisket),
    Food("burger", R.drawable.burger),
    Food("cake", R.drawable.cake),
    Food("casserole", R.drawable.casserole),
    Food("cheese", R.drawable.cheese),
    Food("chicken", R.drawable.chicken),
    Food("chili", R.drawable.chili),
    Food("chop", R.drawable.chop),
    Food("cookie", R.drawable.cookie),
    Food("fish", R.drawable.fish),
    Food("ham", R.drawable.ham),
    Food("meatball", R.drawable.meatball), //meatball should be before meat
    Food("meatloaf", R.drawable.meatloaf), //ditto
    Food("meat", R.drawable.meat),
    Food("pasta", R.drawable.pasta),
    Food("pizza", R.drawable.pizza),
    Food("pie", R.drawable.pie),
    Food("pork", R.drawable.pork),
    Food("potato", R.drawable.potato),
    Food("ribs", R.drawable.ribs),
    Food("rice", R.drawable.rice),
    Food("salad", R.drawable.salad),
    Food("sandwich", R.drawable.sandwich),
    Food("sausage", R.drawable.sausage),
    Food("shrimp", R.drawable.shrimp),
    Food("soup", R.drawable.soup),
    Food("steak", R.drawable.steak),
    Food("stew", R.drawable.stew),
    Food("turkey", R.drawable.turkey),
    Food("slowcook", R.drawable.slowcook) //somewhat generic so I put last
)
private val genericFood = Food("food", R.drawable.food)

fun getFood(input: String): Food {
    foodList.forEach {
        if (input.contains(it.imageName))
            return it
    }
    return genericFood
}



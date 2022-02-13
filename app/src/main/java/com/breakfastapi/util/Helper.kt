package com.breakfastapi.util

import com.breakfastapi.network.removeBrackets

object Helper {
    fun getListFromString(input: String, delimiter: String): List<String> {
        var newInput = removeBrackets(input)
        var output = mutableListOf<String>()
        val list: List<String> = newInput.split(delimiter).map { it -> it.trim() }
        list.forEach { it ->
            if (it.isNotEmpty())
                output.add("$it")
        }
        return output
    }
}
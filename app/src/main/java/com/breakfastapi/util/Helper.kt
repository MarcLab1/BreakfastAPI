package com.breakfastapi.util

import com.breakfastapi.network.removeBrackets
import java.lang.StringBuilder

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

    fun getTimeFormatted(mins: Long) : String
    {
        val hours: Int = mins.toInt() / 60
        val minutes: Int = mins.toInt() % 60
        var time : StringBuilder = StringBuilder("")
        if(hours!=0)
            time.append("${hours}h ")
        if(minutes !=0)
            time.append("${minutes}m")
        if(time.isNotEmpty())
            return time.toString()
        else
            return "?"
    }
}
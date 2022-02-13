package com.breakfastapi.util

enum class NetworkStatus(var msg: String) {

    WAITING("Waiting"),
    LOADING("Loading"),
    ERROR("Error"),
    SUCCESS("Success")
}
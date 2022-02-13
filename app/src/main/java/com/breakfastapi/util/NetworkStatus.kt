package com.breakfastapi.util

enum class NetworkStatus(var msg: String) {

    READY("Ready"),
    LOADING("Loading"),
    ERROR("Error"),
}
package com.github.farzadfarazmand.cleanweather.model.response

import com.google.gson.annotations.SerializedName

data class Location(
    val name: String = "",
    val country: String = "",
    @SerializedName("localtime")
    val localTime: String = ""
)
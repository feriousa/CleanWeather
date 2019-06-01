package com.github.farzadfarazmand.cleanweather.model.response

import com.google.gson.annotations.SerializedName

data class currentWeather(
    @SerializedName("temp_c")
    val temp: Int = 0,
    @SerializedName("is_day")
    val isDay: Int = 1,
    @SerializedName("wind_kph")
    val windSpeed: Int = 0,
    @SerializedName("wind_dir")
    val windDirection: String = "",
    val humidity: Int = 0,
    val uv: Float = 0F
)
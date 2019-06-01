package com.github.farzadfarazmand.cleanweather.model.response

import com.google.gson.annotations.SerializedName

data class DayWeather(
    @SerializedName("avgtemp_c")
    val temp: Int = 0,
    @SerializedName("maxtemp_c")
    val maxTemp: Int = 0,
    @SerializedName("mintemp_c")
    val minTemp: Int = 0,
    @SerializedName("is_day")
    val isDay: Int = 1,
    @SerializedName("maxwind_kph")
    val windSpeed: Int = 0,
    @SerializedName("wind_dir")
    val windDirection: String = "",
    @SerializedName("avghumidity")
    val humidity: Int = 0,
    val uv: Float = 0F
) {
}
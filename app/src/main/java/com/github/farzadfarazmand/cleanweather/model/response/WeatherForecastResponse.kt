package com.github.farzadfarazmand.cleanweather.model.response

import com.google.gson.annotations.SerializedName

object WeatherForecastResponse {

    data class CurrentWeather(
        @SerializedName("temp_c")
        val temp: Float = 0F,
        @SerializedName("is_day")
        val isDay: Int = 1,
        @SerializedName("wind_kph")
        val windSpeed: Float = 0F,
        @SerializedName("wind_dir")
        val windDirection: String = "",
        val humidity: Int = 0,
        val condition: WeatherCondition,
        val uv: Float = 0F
    )

    data class Astro(
        val sunrise: String = "",
        val sunset: String = ""
    )

    data class WeatherCondition(
        val text: String = "",
        val code: Int = 0
    )

    data class WeatherLocation(
        val name: String = "",
        val country: String = "",
        @SerializedName("localtime")
        val localTime: String = ""
    )

    data class DayWeather(
        @SerializedName("avgtemp_c")
        val temp: Float = 0F,
        @SerializedName("maxtemp_c")
        val maxTemp: Float = 0F,
        @SerializedName("mintemp_c")
        val minTemp: Float = 0F,
        @SerializedName("is_day")
        val isDay: Int = 1,
        @SerializedName("maxwind_kph")
        val windSpeed: Float = 0F,
        @SerializedName("wind_dir")
        val windDirection: String = "",
        @SerializedName("avghumidity")
        val humidity: Int = 0,
        val condition: WeatherCondition,
        val uv: Float = 0F
    )

    data class ForecastDay(
        var date: String = "",
        var day: DayWeather,
        var astro: Astro
    )

    data class Forecast(
        @SerializedName("forecastday")
        val forecastDaysArray: ArrayList<ForecastDay>
    )

    data class ForecastResponse(
        val location: WeatherLocation,
        val current:CurrentWeather,
        val forecast: Forecast
    )

}
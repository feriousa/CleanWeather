package com.github.farzadfarazmand.cleanweather.model.response

import com.github.farzadfarazmand.cleanweather.util.Days
import com.github.farzadfarazmand.cleanweather.util.WeatherConditionMap
import com.google.gson.annotations.SerializedName
import java.util.*

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
        val date: String = "",
        @SerializedName("date_epoch")
        val dateEpoch: Long = 0,
        val day: DayWeather,
        val astro: Astro
    ) {
        fun getDayNameFromEpoch(): String {
            val c = Calendar.getInstance()
            c.timeInMillis = dateEpoch * 1000
            val dayNum = c.get(Calendar.DAY_OF_WEEK)
            return Days.values()[dayNum - 1].name
        }

        fun getStatusIcon(): Int = WeatherConditionMap.getInstance().getIconForCondition(day.condition.code)
        fun getMaxTemp(): String = day.maxTemp.toString() + "°"
        fun getMinTemp(): String = " / " + day.minTemp.toString() + "°"
    }

    data class Forecast(
        @SerializedName("forecastday")
        val forecastDaysArray: ArrayList<ForecastDay>
    )

    data class ForecastResponse(
        val location: WeatherLocation,
        val current: CurrentWeather,
        val forecast: Forecast
    )

}
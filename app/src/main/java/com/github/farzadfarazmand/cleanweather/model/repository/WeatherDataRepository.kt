package com.github.farzadfarazmand.cleanweather.model.repository

import android.os.Handler
import com.github.farzadfarazmand.cleanweather.R
import com.github.farzadfarazmand.cleanweather.model.CurrentWeatherData

class WeatherDataRepository {

    fun getCurrentWeather(callback: WeatherDataCallback) {
        Handler().postDelayed({
            callback.onDataReady(CurrentWeatherData("Tehran, Iran", "46", "48°c / 33°c", R.drawable.ic_sunny))
        }, 3000)
    }

    interface WeatherDataCallback {
        fun onDataReady(weatherData: CurrentWeatherData)
    }
}
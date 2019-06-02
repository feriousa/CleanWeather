package com.github.farzadfarazmand.cleanweather.model.repository

import android.content.Context
import android.os.Handler
import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse
import com.google.gson.Gson


class WeatherDataRepository {

    fun getWeatherData(context: Context, callback: WeatherDataCallback) {
        Handler().postDelayed({
            val forecastResponseJson = context.assets.open("sample_response.json").bufferedReader().use{
                it.readText()
            }
            val forecastResponse = Gson().fromJson<WeatherForecastResponse.ForecastResponse>(forecastResponseJson, WeatherForecastResponse.ForecastResponse::class.java)
            callback.onDataReady(forecastResponse)
        }, 6000)
    }

    interface WeatherDataCallback {
        fun onDataReady(weatherData: WeatherForecastResponse.ForecastResponse)
    }
}
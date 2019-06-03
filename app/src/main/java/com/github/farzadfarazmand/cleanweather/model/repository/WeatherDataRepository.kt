package com.github.farzadfarazmand.cleanweather.model.repository

import android.content.Context
import android.os.Handler
import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse
import com.github.farzadfarazmand.cleanweather.network.RetrofitClient
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class WeatherDataRepository {



    fun getWeatherData():Observable<WeatherForecastResponse.ForecastResponse> {
//        Handler().postDelayed({
//            val forecastResponseJson = context.assets.open("sample_response.json").bufferedReader().use{
//                it.readText()
//            }
//            val forecastResponse = Gson().fromJson<WeatherForecastResponse.ForecastResponse>(forecastResponseJson, WeatherForecastResponse.ForecastResponse::class.java)
//            callback.onDataReady(forecastResponse)
//        }, 6000)

        return RetrofitClient.getWeather("Behbahan")
    }

    interface WeatherDataCallback {
        fun onDataReady(weatherData: WeatherForecastResponse.ForecastResponse)
    }
}
package com.github.farzadfarazmand.cleanweather.model.repository

import android.content.Context
import android.text.TextUtils
import com.github.farzadfarazmand.cleanweather.helper.PreferencesHelper
import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse
import com.github.farzadfarazmand.cleanweather.network.RetrofitClient
import com.google.gson.Gson
import io.reactivex.Observable


class WeatherDataRepository {

    private val gson = Gson()

    fun getWeatherData(context: Context): Observable<WeatherForecastResponse.ForecastResponse> {
        return Observable.merge(
            getWeatherDataFromCache(context),
            getWeatherDataFromApi()
                .map {
                    PreferencesHelper.saveWeatherData(context, gson.toJson(it))
                    it
                })

    }

    private fun getWeatherDataFromApi(): Observable<WeatherForecastResponse.ForecastResponse> {
        return RetrofitClient.getWeather("Tehran")
    }

    private fun getWeatherDataFromCache(context: Context): Observable<WeatherForecastResponse.ForecastResponse> {
        return Observable.create {
            val jsonResponse = PreferencesHelper.getCachedWeatherData(context)
            if (!TextUtils.isEmpty(jsonResponse))
                it.onNext(gson.fromJson(jsonResponse, WeatherForecastResponse.ForecastResponse::class.java))
            else
                Observable.empty<WeatherForecastResponse.ForecastResponse>()
        }
    }
}
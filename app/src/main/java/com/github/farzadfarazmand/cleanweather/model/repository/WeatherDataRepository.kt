package com.github.farzadfarazmand.cleanweather.model.repository

import android.content.Context
import com.github.farzadfarazmand.cleanweather.helper.PreferencesHelper
import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse
import com.github.farzadfarazmand.cleanweather.network.RetrofitClient
import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class WeatherDataRepository {

    fun getWeatherData(context: Context): Single<WeatherForecastResponse.ForecastResponse> {
        return RetrofitClient.getWeather("Behbahan")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                PreferencesHelper.saveWeatherData(context, Gson().toJson(it))
                it
            }
    }
}
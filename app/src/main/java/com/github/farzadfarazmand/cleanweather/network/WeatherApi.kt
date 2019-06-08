package com.github.farzadfarazmand.cleanweather.network

import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast.json")
    fun getWeather(
        @Query("key") key: String,
        @Query("q") cityName: String,
        @Query("days") days: Int
    ): Single<WeatherForecastResponse.ForecastResponse>

}
package com.github.farzadfarazmand.cleanweather.network

import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val weatherApi: WeatherApi

    init {
        weatherApi = getClient("https://api.apixu.com/v1/").create(WeatherApi::class.java)
    }

    private fun getClient(baseUrl: String): Retrofit {
        //create okHttp client
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    fun getWeather(cityName: String): Observable<WeatherForecastResponse.ForecastResponse> {
        return weatherApi.getWeather("0f6741ce6a0441c496852933190106", cityName, 7)
    }


}
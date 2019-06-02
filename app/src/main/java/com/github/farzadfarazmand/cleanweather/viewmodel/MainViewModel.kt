package com.github.farzadfarazmand.cleanweather.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.github.farzadfarazmand.cleanweather.model.repository.WeatherDataRepository
import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val weatherDataRepository = WeatherDataRepository()
    val isLoading = ObservableField<Boolean>(false)
    val weatherData = MutableLiveData<WeatherForecastResponse.ForecastResponse>()

    fun getWeatherData() {
        isLoading.set(true)
        weatherDataRepository.getWeatherData(getApplication(), object : WeatherDataRepository.WeatherDataCallback {
            override fun onDataReady(weatherData: WeatherForecastResponse.ForecastResponse) {
                isLoading.set(false)
                this@MainViewModel.weatherData.value = weatherData
            }
        })
    }

}
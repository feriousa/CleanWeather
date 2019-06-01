package com.github.farzadfarazmand.cleanweather.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.farzadfarazmand.cleanweather.model.CurrentWeatherData
import com.github.farzadfarazmand.cleanweather.model.repository.WeatherDataRepository

class MainActivityViewModel : ViewModel() {

    private val weatherDataRepository = WeatherDataRepository()
    val isLoading = ObservableField<Boolean>(false)
    val currentWeather = MutableLiveData<CurrentWeatherData>()

    fun getWeatherData() {
        isLoading.set(true)
        weatherDataRepository.getCurrentWeather(object : WeatherDataRepository.WeatherDataCallback {
            override fun onDataReady(weatherData: CurrentWeatherData) {
                isLoading.set(false)
                currentWeather.value = weatherData
            }
        })
    }

}
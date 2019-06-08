package com.github.farzadfarazmand.cleanweather.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.github.farzadfarazmand.cleanweather.model.repository.WeatherDataRepository
import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val weatherDataRepository = WeatherDataRepository()
    val isLoading = ObservableField<Boolean>(false)
    val weatherData = MutableLiveData<WeatherForecastResponse.ForecastResponse>()

    fun getWeatherData() {
        isLoading.set(true)
        compositeDisposable.add(
            weatherDataRepository.getWeatherData(getApplication())
                .subscribeWith(object : DisposableSingleObserver<WeatherForecastResponse.ForecastResponse>() {
                    override fun onSuccess(t: WeatherForecastResponse.ForecastResponse) {
                        isLoading.set(false)
                        weatherData.value = t
                    }

                    override fun onError(e: Throwable) {
                        isLoading.set(false)
                        Log.e("MainViewModel", "error => " + e.message)
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }

}
package com.github.farzadfarazmand.cleanweather.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.farzadfarazmand.cleanweather.R
import com.github.farzadfarazmand.cleanweather.databinding.ActivityMainBinding
import com.github.farzadfarazmand.cleanweather.model.CurrentWeatherData
import com.github.farzadfarazmand.cleanweather.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
//        val weatherData = CurrentWeatherData("Tehran, Iran", "46", "48°c / 33°c", R.drawable.ic_sunny)
        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()
        viewModel.getWeatherData()

        viewModel.currentWeather.observe(this,
            Observer<CurrentWeatherData> {
                it?.let {
                    binding.apply {
                        currentLocation.text = it.cityName
                        currentWeatherIcon.setImageResource(it.status)
                        currentWeatherTemp.text = it.temp
                        currentWeatherMaxMinTemp.text = it.minMaxTemp
                    }
                }
            })
    }
}

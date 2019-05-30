package com.github.farzadfarazmand.cleanweather.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.farzadfarazmand.cleanweather.R
import com.github.farzadfarazmand.cleanweather.databinding.ActivityMainBinding
import com.github.farzadfarazmand.cleanweather.model.WeatherData

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
        val weatherData = WeatherData("Tehran, Iran", "46", "48°c / 33°c", R.drawable.ic_sun)
        binding.weatherData = weatherData
        binding.executePendingBindings()
    }
}

package com.github.farzadfarazmand.cleanweather.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.farzadfarazmand.cleanweather.R
import com.github.farzadfarazmand.cleanweather.databinding.ActivityMainBinding
import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse
import com.github.farzadfarazmand.cleanweather.util.WeatherConditionMap
import com.github.farzadfarazmand.cleanweather.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()
        viewModel.getWeatherData()

        viewModel.weatherData.observe(this,
            Observer<WeatherForecastResponse.ForecastResponse> {
                it?.let {
                    binding.apply {
                        currentLocation.text = it.location.name + ", " + it.location.country
                        currentWeatherIcon.setImageResource(WeatherConditionMap.getInstance().getIconForCondition(it.current.condition.code))
                        currentWeatherTemp.text = (it.current.temp.toInt()).toString()
                        currentWeatherMaxMinTemp.text = (it.current.humidity).toString()
                    }
                }
            })
    }
}

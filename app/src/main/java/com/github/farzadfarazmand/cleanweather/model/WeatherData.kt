package com.github.farzadfarazmand.cleanweather.model

class WeatherData(
    var cityName: String = "",
    var date: String = "",
    var temp: String = "",
    var status: Int,
    var description: String = "",
    var sunriseTime: String = "",
    var sunsetTime: String = "",
    var wind: String = ""
)
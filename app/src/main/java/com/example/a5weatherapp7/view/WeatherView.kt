package com.example.a5weatherapp7.view

import com.example.a5weatherapp7.model.WeatherModel

interface WeatherView {

    fun showWeather(weatherModel: WeatherModel)
    fun showError(error: String)
}
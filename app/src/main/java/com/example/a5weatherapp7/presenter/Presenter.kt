package com.example.a5weatherapp7.presenter

import android.util.Log
import com.example.a5weatherapp7.model.WeatherApi
import com.example.a5weatherapp7.model.WeatherModel
import com.example.a5weatherapp7.view.WeatherView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/*apikey: String,
latitude: String,
longitude: String,
appid: String,
units: String*/

class Presenter @Inject constructor(private val weatherApi: WeatherApi) {
    lateinit var weatherView: WeatherView

    fun getWeatherDetails(

    ) {
        weatherApi.getWeather().enqueue(object : Callback<WeatherModel> {
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                response.body()?.let { weatherView.showWeather(it) }
                // weatherView.showWeather(response.body()!!)


            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {

            }


        })
    }

    fun attachView(view: WeatherView) {
        this.weatherView = view
    }

}
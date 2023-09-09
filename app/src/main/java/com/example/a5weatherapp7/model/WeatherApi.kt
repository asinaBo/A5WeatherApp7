package com.example.a5weatherapp7.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherApi {


   // http://api.weatherapi.com/v1/current.json?key=92359178a130484998f51026231103&q=Bishkek&aqi=no

    @GET("data/2.5/weather")//data/2.5/weather
    fun getWeather(@Query("lat") latitude: String = "42.882",
                   @Query("lon") longitude: String = "74.5827",
                   @Query("appid") appid: String= "36cbf21e77603d1848c9293fd5e5ba31",
                   @Query("units") units: String= "metric"): Call<WeatherModel>
}

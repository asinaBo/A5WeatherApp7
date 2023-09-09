package com.example.a5weatherapp7.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class WeatherModel(
    var name: String,
    var main: MainModel,
    var sys: RiseNSet,
    var clouds : Clouds,
    var weather: ArrayList<Condition>

) : Serializable

data class Clouds(
    var all : Double
)

data class MainModel(
    var temp: Double,
    var feels_like: Double,
    var pressure: Double,
    @SerializedName("temp_min")
    var min: Double,
    @SerializedName("temp_max")
    var max: Double,
    var humidity: Int
)
data class RiseNSet(
   var  sunrise: Double,
   var  sunset: Double
)

data class Condition(
    var main : String,
    var icon: String
)

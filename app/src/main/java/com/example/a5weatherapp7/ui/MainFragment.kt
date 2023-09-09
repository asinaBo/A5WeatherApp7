package com.example.a5weatherapp7.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.Coil
import coil.load
import com.example.a5weatherapp7.databinding.ActivityMainBinding
import com.example.a5weatherapp7.databinding.FragmentMainBinding
import com.example.a5weatherapp7.model.WeatherModel
import com.example.a5weatherapp7.presenter.Presenter
import com.example.a5weatherapp7.view.WeatherView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainFragment : Fragment(),WeatherView {
    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var presenter: Presenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.getWeatherDetails()

    }

    override fun showWeather(weatherModel: WeatherModel) {

        with(binding){
            tvCity.text = weatherModel.name
            tvCurrentTemp.append(weatherModel.main.temp.toString() + "°C")
            tvHumidity.append("humidity:  " + weatherModel.main.humidity.toString() + "%")
            tvRealFeel.append("Real feel:  " + weatherModel.main.feels_like.toString() + "°")
            tvPressure.append("Pressure:  " + weatherModel.main.pressure.toString())
            tvMaxMin.append(weatherModel.main.max.toString() +"/"+ weatherModel.main.min.toString())
            tvSunrise.append("sunrise:  " + weatherModel.sys.sunrise.toString())
            tvSunset.append("sunrise:  " + weatherModel.sys.sunset.toString())

            weatherModel.weather.forEach {
                tvCondition.append(it.main)
            }

        }

    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}
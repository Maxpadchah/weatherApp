package com.example.weatherapp.ui.view

import com.example.weatherapp.model.WeatherDTO

interface DetailsRepository {
    fun getWeatherDetailsFromServer(
    lat: Double,
    lon: Double,
    callback: retrofit2.Callback<WeatherDTO>
)

}
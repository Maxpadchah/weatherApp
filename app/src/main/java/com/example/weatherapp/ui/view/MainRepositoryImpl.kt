package com.example.weatherapp.ui.view

import com.example.weatherapp.model.Weather
import com.example.weatherapp.model.getRussianCities
import com.example.weatherapp.model.getWorldCities

class MainRepositoryImpl :
    MainRepository {

    override fun getWeatherFromServer() =
        Weather()

    override fun getWeatherFromLocalStorageRus() =
        getRussianCities()

    override fun getWeatherFromLocalStorageWorld() =
        getWorldCities()
}
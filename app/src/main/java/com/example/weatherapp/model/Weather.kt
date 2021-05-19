package com.example.weatherapp.model

data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Double = 28.4,
    val pressure: Double = 759.4,
    val humidity: Double = 59.3
)

fun getDefaultCity() = City("Лиски, Воронежская область",
    55.755826, 37.617299905)
package com.example.weatherapp.model


import android.os.Parcelable

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int? = 28,
    val pressure: Int = 759,
    val humidity: String = "59.3",
    val condition: String? = "sunny",
    val icon: String? = "bkn_n"
) : Parcelable

fun getDefaultCity() = City(
    "Лиски, Воронежская область",
    55.755826, 37.617299905
)


fun getWorldCities() = listOf(
    Weather(City("Лондон", 51.5085300, -0.1257400), 2),
    Weather(City("Токио", 35.6895000, 139.6917100), 2),
    Weather(City("Париж", 48.8534100, 2.3488000), 4),
    Weather(City("Берлин", 52.52000659999999, 13.404953999999975), 7),
    Weather(City("Рим", 41.9027835, 12.496365500000024), 12),
    Weather(City("Минск", 53.90453979999999, 27.561524400000053), 2),
    Weather(City("Стамбул", 41.0082376, 28.97835889999999), 2),
    Weather(City("Вашингтон", 38.9071923, -77.03687070000001), 2),
    Weather(City("Киев", 50.4501, 30.523400000000038), 4),
    Weather(City("Пекин", 39.90419989999999, 116.40739630000007), 8)
)

fun getRussianCities() = listOf(
    Weather(City("Москва", 55.755826, 37.617299900000035), 23),
    Weather(City("Санкт-Петербург", 59.9342802, 30.335098600000038), 22),
    Weather(City("Новосибирск", 55.00835259999999, 82.93573270000002), 12),
    Weather(City("Екатеринбург", 56.83892609999999, 60.60570250000001), 14),
    Weather(City("Нижний Новгород", 56.2965039, 43.936059), 14),
    Weather(City("Казань", 55.8304307, 49.06608060000008), 16),
    Weather(City("Челябинск", 55.1644419, 61.4368432), 23),
    Weather(City("Омск", 54.9884804, 73.32423610000001), 4),
    Weather(City("Ростов-на-Дону", 47.2357137, 39.701505), 16),
    Weather(City("Уфа", 54.7387621, 55.972055400000045), 20)
)

package com.example.weatherapp.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField


data class City (
    val city: String,
    val lat: Double,
    val lon: Double
)



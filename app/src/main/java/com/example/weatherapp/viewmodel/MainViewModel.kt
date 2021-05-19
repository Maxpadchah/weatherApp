package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.Repository
import com.example.weatherapp.model.RepositoryImpl

class MainViewModel (
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()):
    ViewModel() {

        fun getLiveData() = liveDataToObserve

        fun getWeatherFromLocalSource() = getDataFromLocalSource()

        private fun getDataFromLocalSource() {
            liveDataToObserve.value = AppState.Loading
            Thread {
                Thread.sleep(1000)
                liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWeatherFromLocalStorage()))
            }.start()
        }
}

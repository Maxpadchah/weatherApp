package com.example.weatherapp.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.weatherapp.R
import com.example.weatherapp.databinding.MainFragmentBinding
import com.example.weatherapp.model.Weather
import com.example.weatherapp.viewmodel.AppState
import com.example.weatherapp.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getWeatherFromLocalSource()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val weatherData = appState.weatherData
                setData(weatherData)
            }
            is AppState.Error -> {
                Snackbar
                    .make(binding.main, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.reload)) { viewModel.getWeatherFromLocalSource() }
                    .show()
            }
        }
    }

    private fun setData(weatherData: Weather) {
        binding.cityField.text = weatherData.city.city
        binding.updatedField.text = String.format(
            getString(R.string.city_coordinates),
            weatherData.city.lat.toString(),
            weatherData.city.lon.toString()
        )
        binding.currentTemperatureField.text = weatherData.temperature.toString() + " C"
        binding.detailsFieldPressure.text = "Давление: " + weatherData.pressure.toString()
        binding.detailsFieldHumidity.text = "Влажность: " + weatherData.humidity.toString() + "%"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}
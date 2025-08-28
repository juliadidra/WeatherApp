package com.example.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.api.WeatherService
import com.example.weatherapp.db.fb.FBDatabase
import com.example.weatherapp.monitor.ForecastMonitor
import com.example.weatherapp.repo.Repository

class MainViewModelFactory(private val repository : Repository,
                           private val service : WeatherService,
                           private val monitor: ForecastMonitor) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository, service, monitor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
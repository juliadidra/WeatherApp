package com.example.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.api.WeatherService
import com.example.weatherapp.db.fb.FBDatabase
import com.example.weatherapp.monitor.ForecastMonitor

class MainViewModelFactory(private val db : FBDatabase,
                           private val service : WeatherService,
                           private val monitor: ForecastMonitor) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(db, service, monitor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
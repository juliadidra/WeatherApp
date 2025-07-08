package com.example.weatherapp

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.weatherapp.ui.model.City
import com.google.android.gms.maps.model.LatLng

class MainViewModel : ViewModel() {
    private val _cities = getCities().toMutableStateList()
    val cities
        get() = _cities.toList()
    fun remove(city: City) {
        _cities.remove(city)
    }
    fun add(name: String, location: LatLng? = null) {
        _cities.add(City(name = name, location = location))
    }

}

private fun getCities() = List(20) { i ->
    City(name = "Cidade $i", weather = "Carregando clima...")
}
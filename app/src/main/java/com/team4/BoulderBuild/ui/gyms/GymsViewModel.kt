package com.team4.BoulderBuild.ui.gyms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GymsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Listado de gyms"
    }
    val text: LiveData<String> = _text
}
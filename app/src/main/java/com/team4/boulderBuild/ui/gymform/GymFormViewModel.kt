package com.team4.boulderBuild.ui.gymform

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.team4.usecases.FindGymById
import com.team4.usecases.UpdateGym
import com.team4.domain.Gym
import com.team4.boulderBuild.ui.common.ScopedViewModel
import kotlinx.coroutines.launch

class GymFormViewModel(private val gymId : Int,
                       private val findGymById: FindGymById,
                       private val updateGym: UpdateGym) : ScopedViewModel() {

    private val _model = MutableLiveData<Gym>()
    val model : LiveData<Gym> get() = _model

    // Two-way databinding, exposing MutableLiveData
    val _name = MutableLiveData<String>()
    val _description = MutableLiveData<String>()

    init {
        launch {
            //ApplicationDI.getGymsRepository()?.getAllGyms()
            Log.d("Form", "oncreate!!!!!!!!!!!!!!!!!!!!!!!!!!!!" )
            _model.value = findGymById.invoke(gymId)
            updateUi()
        }
    }

    fun onClickSubmit() {
        launch {
            Log.d("Form", "onclick@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" )
            model.value?.let {
                val updatedGym = it.copy(name = _name.value ?: "", description = _description.value ?: "")
                _model.value = updatedGym
                updateUi()
                saveData()
            }
        }
    }

    private fun updateUi() {
        model.value?.run {
            _name.value = name
            _description.value = description
        }
    }

    private fun saveData(){
        launch {
            _model.value?.let { saveNewData(it) }
        }
    }

    private suspend fun saveNewData(newModel : Gym){
        updateGym.invoke(newModel)
        _model.postValue(newModel)
    }
}

class GymFormViewModelFactory(private val gymId : Int,
                              private val findGymById: FindGymById,
                              private val updateGym: UpdateGym) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GymFormViewModel(gymId, findGymById, updateGym) as T
    }

}
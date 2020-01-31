package com.team4.boulderBuild.ui.gymform


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.team4.boulderBuild.config.ApplicationDI
import com.team4.domain.Gym
import com.team4.boulderBuild.ui.common.ScopedViewModel
import kotlinx.coroutines.launch

class GymFormViewModel(private val gymId : Int) : ScopedViewModel() {

    private val _model = MutableLiveData<Gym>()
    val model : LiveData<Gym> get() = _model

    init {
        launch {
            _model.value ?: ApplicationDI.getGymsRepository()?.findGymById(gymId)
            updateUi()
        }
    }

    private fun saveData(){
        launch {
            _model.value?.let { saveNewData(it) }
        }
    }

    private suspend fun saveNewData(newModel : Gym){
        ApplicationDI.getGymsRepository()?.update(newModel)
        _model.postValue(newModel)
    }

    fun onClickSubmit() {
        launch {
            Log.e("Form", "onclick@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" )
            model.value?.let {
                _model.value = it
                updateUi()
                saveData()
            }
        }
    }

    private fun updateUi() {
        model.value?.run {
            _model.value = this
        }
    }

}

class GymFormViewModelFactory(private val gymId : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GymFormViewModel(gymId) as T
    }

}
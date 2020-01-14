package com.team4.BoulderBuild.ui.gymform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.team4.BoulderBuild.config.ApplicationDI
import com.team4.BoulderBuild.model.domain.Gym
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class GymFormViewModel(private val gymId : Int) : ViewModel() {

    data class UiModel(val gym : Gym)

    private val _model = MutableLiveData<UiModel>()

    val model : LiveData<UiModel>
        get() {
            if(_model.value == null){
                findGym()
            }
            return _model
        }

    private fun findGym() {
        GlobalScope.async {
            val gym = ApplicationDI.getGymsRepository()?.findGymById(gymId)
            if(gym != null){
                _model.postValue(UiModel(gym))
            }
        }
    }

    suspend fun saveNewData(newModel : Gym){
        ApplicationDI.getGymsRepository()?.update(newModel)
        _model.postValue(UiModel(newModel))
    }


}

class GymFormViewModelFactory(private val gymId : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GymFormViewModel(gymId) as T
    }

}
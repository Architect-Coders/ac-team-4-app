package com.team4.BoulderBuild.ui.gymform

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.team4.BoulderBuild.BoulderBuildApp
import com.team4.BoulderBuild.R
import com.team4.BoulderBuild.config.ApplicationDI
import com.team4.BoulderBuild.model.domain.Gym
import kotlinx.android.synthetic.main.activity_gym_form.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class GymFormActivity : AppCompatActivity() {

    companion object {
        const val GYM_ID = "GymFormActivity:gymId"
    }

    private lateinit var gymFormViewModel: GymFormViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_form)

        initModel()
    }

    fun initModel(){
        gymFormViewModel =
            ViewModelProviders.of(this, GymFormViewModelFactory(intent.getIntExtra(GYM_ID, -1))).get(GymFormViewModel::class.java)

        gymFormViewModel.model.observe(this, Observer(::updateUi))

        btSubmit.setOnClickListener {
            saveData()
        }

    }

    fun updateUi(model : GymFormViewModel.UiModel) = with(model.gym){
        etGymName.setText(this.name)
        etGymDescription.setText(this.description)
        etLocationLat.setText(this.lat?.toString())
        etLocationLon.setText(this.lon?.toString())
    }

    fun saveData(){
        GlobalScope.async {
            var newId =gymFormViewModel.model.value?.gym?.id
            var gym = Gym(
                newId,
                etGymName.text.toString(),
                etGymDescription.text.toString(),
                etLocationLat.text?.toString()?.toDoubleOrNull(),
                etLocationLon.text?.toString()?.toDoubleOrNull(),
                gymFormViewModel.model.value?.gym?.imgSrc // TODO: change to current file
            )
            gymFormViewModel.saveNewData(gym)
        }
    }
}
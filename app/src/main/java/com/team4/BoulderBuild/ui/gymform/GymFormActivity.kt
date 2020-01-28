package com.team4.BoulderBuild.ui.gymform

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.team4.BoulderBuild.R

import com.team4.domain.Gym
import kotlinx.android.synthetic.main.activity_gym_form.*


class GymFormActivity : AppCompatActivity() {

    companion object {
        const val GYM_ID = "GymFormActivity:gymId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_form)

        initModel()
    }

    private lateinit var gymFormViewModel: GymFormViewModel
    private fun initModel(){
        gymFormViewModel =
            ViewModelProviders.of(this, GymFormViewModelFactory(intent.getIntExtra(GYM_ID, -1))).get(GymFormViewModel::class.java)

        gymFormViewModel.model.observe(this, Observer(::updateUi))

        btSubmit.setOnClickListener {
            gymFormViewModel.saveData()
        }

    }

    private fun updateUi(model : GymFormViewModel.UiModel) = with(model.gym){
        etGymName.setText(this.name)
        etGymDescription.setText(this.description)
        etLocationLat.setText(this.lat?.toString())
        etLocationLon.setText(this.lon?.toString())
    }


}
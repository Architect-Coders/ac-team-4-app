package com.team4.boulderBuild.ui.gymform

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.team4.usecases.FindGymById
import com.team4.usecases.UpdateGym
import com.team4.boulderBuild.R

import com.team4.boulderBuild.databinding.ActivityGymFormBinding
import com.team4.boulderBuild.model.data.database.GymDatabase
import com.team4.boulderBuild.model.data.database.GymsRoomDataSource
import com.team4.boulderBuild.model.data.server.GymsRemoteDataSource
import com.team4.data.repository.GymsRepository

class GymFormActivity : AppCompatActivity() {

    companion object {
        const val GYM_ID = "GymFormActivity:gymId"
    }
    private lateinit var gymFormViewModel: GymFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        val gymsRepository = GymsRepository(
            GymsRoomDataSource(
                GymDatabase.buildDatabase(this)
            ),
            GymsRemoteDataSource()
        )

        gymFormViewModel =
            ViewModelProviders.of(this,
                    GymFormViewModelFactory(intent.getIntExtra(GYM_ID, 1),
                        FindGymById(gymsRepository),
                        UpdateGym(gymsRepository)
                    )
            ).get(GymFormViewModel::class.java)

        val binding: ActivityGymFormBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_gym_form)

        binding.viewmodel = gymFormViewModel
        binding.lifecycleOwner = this
    }
}
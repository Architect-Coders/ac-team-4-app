package com.team4.boulderBuild.ui.gymform

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.team4.boulderBuild.R

import com.team4.boulderBuild.databinding.ActivityGymFormBinding
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GymFormActivity : AppCompatActivity() {

    companion object {
        const val GYM_ID = "GymFormActivity:gymId"
    }

    private val gymFormViewModel: GymFormViewModel by currentScope.viewModel(this) {
        parametersOf(intent.getIntExtra(GYM_ID, 1))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        val binding: ActivityGymFormBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_gym_form)

        binding.viewmodel = gymFormViewModel
        binding.lifecycleOwner = this
    }
}
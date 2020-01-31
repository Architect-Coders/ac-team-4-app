package com.team4.boulderBuild.ui.gymform

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.team4.boulderBuild.R
import com.team4.boulderBuild.databinding.ActivityGymFormBinding

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.Observer

class GymFormActivity : AppCompatActivity() {

    companion object {
        const val GYM_ID = "GymFormActivity:gymId"
    }
    private lateinit var gymFormViewModel: GymFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        Log.d(GYM_ID, "oncreate!!!!!!!!!!!!!!!!!!!!!!!!!!!!" )
        gymFormViewModel =
            ViewModelProviders.of(this, GymFormViewModelFactory(intent.getIntExtra(GYM_ID, 1))).get(GymFormViewModel::class.java)


        gymFormViewModel.model.observe(this, Observer { res ->
            Log.e("Form", res.name )
        })

        val binding: ActivityGymFormBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_gym_form)

        binding.viewmodel = gymFormViewModel
        binding.lifecycleOwner = this
    }
}
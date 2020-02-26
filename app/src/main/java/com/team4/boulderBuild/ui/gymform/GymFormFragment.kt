package com.team4.boulderBuild.ui.gymform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.team4.boulderBuild.databinding.GymFormFragmentBinding

import com.team4.boulderBuild.R
import com.team4.boulderBuild.ui.common.bindingInflate

import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GymFormFragment : Fragment() {

    companion object {
        const val GYM_ID = "GymFormFragment:gymId"
    }

    private var binding: GymFormFragmentBinding? = null
    private val args: GymFormFragmentArgs by navArgs()

    private val gymFormViewModel: GymFormViewModel by currentScope.viewModel(this) {
        parametersOf(args.id)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = container?.bindingInflate(R.layout.gym_form_fragment, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            viewmodel = gymFormViewModel
            lifecycleOwner = this@GymFormFragment
        }
    }
}

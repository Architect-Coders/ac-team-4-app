package com.team4.boulderbuild.ui.gymform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.team4.boulderbuild.R
import com.team4.boulderbuild.databinding.GymFormFragmentBinding
import com.team4.boulderbuild.ui.common.bindingInflate
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GymFormFragment : Fragment() {

    companion object {
        const val GYM_ID = "GymFormFragment:gymId"
    }

    private var binding: GymFormFragmentBinding? = null
    private val args: GymFormFragmentArgs by navArgs()

    private val gymFormViewModel: GymFormViewModel by viewModel() {
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

package com.team4.boulderBuild.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.team4.boulderBuild.R
import com.team4.boulderBuild.databinding.FragmentDashboardBinding
import com.team4.boulderBuild.ui.common.bindingInflate
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by currentScope.viewModel(this)
    private var binding: FragmentDashboardBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = container?.bindingInflate(R.layout.fragment_dashboard, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            viewmodel = dashboardViewModel
            lifecycleOwner = this@DashboardFragment
        }
    }
}
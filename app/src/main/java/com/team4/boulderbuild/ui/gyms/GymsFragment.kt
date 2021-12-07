package com.team4.boulderbuild.ui.gyms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.team4.boulderbuild.R
import com.team4.boulderbuild.databinding.FragmentGymListBinding
import com.team4.boulderbuild.ui.common.EventObserver
import com.team4.boulderbuild.ui.common.addVerticalItemSeparationInDp
import com.team4.boulderbuild.ui.common.bindingInflate
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class GymsFragment : Fragment() {

    private lateinit var adapter: GymListAdapter
    private lateinit var navController: NavController
    private val gymsViewModel: GymsViewModel by currentScope.viewModel(this)
    private var binding: FragmentGymListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = container?.bindingInflate(R.layout.fragment_gym_list, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        gymsViewModel.navigateToGym.observe(viewLifecycleOwner, EventObserver { id ->
            val action = GymsFragmentDirections.actionNavigationGymsToGymFormFragment(id)
            navController.navigate(action)
        })

        adapter = GymListAdapter(gymsViewModel::onMovieClicked)
        binding?.rvGymList?.adapter = adapter
        binding?.rvGymList?.addVerticalItemSeparationInDp(resources.getDimension(R.dimen.list_margin).toInt())

        binding?.apply {
            viewmodel = gymsViewModel
            lifecycleOwner = this@GymsFragment
        }
    }
}
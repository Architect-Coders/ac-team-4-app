package com.team4.boulderBuild.ui.gyms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.team4.boulderBuild.databinding.FragmentGymsBinding

import com.team4.boulderBuild.R
import com.team4.boulderBuild.ui.common.Event
import com.team4.boulderBuild.ui.common.EventObserver
import com.team4.boulderBuild.ui.common.bindingInflate
import kotlinx.android.synthetic.main.fragment_gyms.*
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class GymsFragment : Fragment() {

    private lateinit var adapter: GymsAdapter
    private lateinit var navController: NavController
    private val gymsViewModel: GymsViewModel by currentScope.viewModel(this)
    private var binding: FragmentGymsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = container?.bindingInflate(R.layout.fragment_gyms, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        gymsViewModel.navigateToGym.observe(viewLifecycleOwner, EventObserver { id ->
            val action = GymsFragmentDirections.actionNavigationGymsToGymFormFragment(id)
            navController.navigate(action)
        })

        adapter = GymsAdapter(gymsViewModel::onMovieClicked)
        recycler.adapter = adapter

        binding?.apply {
            viewmodel = gymsViewModel
            lifecycleOwner = this@GymsFragment
        }
    }
}
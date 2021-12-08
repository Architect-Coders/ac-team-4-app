package com.team4.boulderbuild.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team4.boulderbuild.R
import com.team4.boulderbuild.databinding.FragmentNotificationsBinding
import com.team4.boulderbuild.ui.common.bindingInflate
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotificationsFragment : ScopeFragment() {

    private val notificationsViewModel: NotificationsViewModel by viewModel()
    private var binding: FragmentNotificationsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = container?.bindingInflate(R.layout.fragment_notifications, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            viewmodel = notificationsViewModel
            lifecycleOwner = this@NotificationsFragment
        }
    }
}

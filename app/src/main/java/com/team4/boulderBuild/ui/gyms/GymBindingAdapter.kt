package com.team4.boulderBuild.ui.gyms

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.team4.domain.Gym

@BindingAdapter("items")
fun RecyclerView.setItems(gyms: List<Gym>?) {
    (adapter as? GymListAdapter)?.let {
        it.gyms = gyms ?: emptyList()
    }
}
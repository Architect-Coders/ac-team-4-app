package com.team4.boulderBuild.ui.gyms

import com.team4.boulderBuild.R
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team4.boulderBuild.databinding.RowGymBinding
import com.team4.boulderBuild.ui.common.basicDiffUtil
import com.team4.boulderBuild.ui.common.bindingInflate
import com.team4.domain.Gym

class GymsAdapter(private val listener: (Gym) -> Unit) :
    RecyclerView.Adapter<GymsAdapter.ViewHolder>() {

    var gyms: List<Gym> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.bindingInflate(R.layout.row_gym, false))

    override fun getItemCount(): Int = gyms.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gym = gyms[position]
        holder.dataBinding.gym = gym
        holder.itemView.setOnClickListener { listener(gym) }
    }

    class ViewHolder(val dataBinding: RowGymBinding) : RecyclerView.ViewHolder(dataBinding.root)
}
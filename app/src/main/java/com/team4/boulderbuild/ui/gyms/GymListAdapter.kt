package com.team4.boulderbuild.ui.gyms


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team4.boulderbuild.R
import com.team4.boulderbuild.databinding.ItemGymActionsBinding
import com.team4.boulderbuild.ui.common.basicDiffUtil
import com.team4.boulderbuild.ui.common.bindingInflate
import com.team4.domain.Gym


class GymListAdapter(
    private val listener: (Gym) -> Unit
): RecyclerView.Adapter<GymListAdapter.ViewHolder>() {

    var gyms: List<Gym> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.bindingInflate(R.layout.item_gym_actions, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentGym = gyms[position]
        holder.dataBinding.gym = currentGym
        holder.itemView.setOnClickListener{
            listener(currentGym)
        }
    }

    override fun getItemCount(): Int = gyms.size

    inner class ViewHolder(val dataBinding: ItemGymActionsBinding) : RecyclerView.ViewHolder(dataBinding.root)
}

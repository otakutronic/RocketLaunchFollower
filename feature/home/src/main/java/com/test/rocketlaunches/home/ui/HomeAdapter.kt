package com.test.rocketlaunches.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.rocketlaunches.domain.model.Launch
import com.test.rocketlaunches.home.databinding.ItemViewLaunchBinding

class HomeAdapter : ListAdapter<Launch, RecyclerView.ViewHolder>(LaunchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CurrenciesViewHolder(
            ItemViewLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val launch = getItem(position)
        (holder as CurrenciesViewHolder).bind(launch)
    }

    inner class CurrenciesViewHolder(private val binding: ItemViewLaunchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(launchItem: Launch) {
            binding.apply {
                launch = launchItem
                executePendingBindings()
            }
        }
    }
}

private class LaunchDiffCallback : DiffUtil.ItemCallback<Launch>() {

    override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem == newItem
    }
}

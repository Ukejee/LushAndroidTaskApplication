package com.ukejee.lushandroidtaskapplication.feature.launch.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.ukejee.lushandroidtaskapplication.common.setImage
import com.ukejee.lushandroidtaskapplication.databinding.ItemLaunchBinding
import com.ukejee.lushandroidtaskapplication.feature.launch.model.Launch

class LaunchListViewHolder(private val binding: ItemLaunchBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(item: Launch) {
        binding.title.text = item.name
        binding.badgeImage.setImage(item.badgeImageUrl ?: "")
        binding.date.text = item.launchDate
        binding.status.text = item.missionStatus
    }
}


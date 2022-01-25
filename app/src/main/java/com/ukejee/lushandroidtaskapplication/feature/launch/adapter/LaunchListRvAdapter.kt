package com.ukejee.lushandroidtaskapplication.feature.launch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ukejee.lushandroidtaskapplication.databinding.ItemLaunchBinding
import com.ukejee.lushandroidtaskapplication.feature.launch.adapter.viewHolder.LaunchListViewHolder
import com.ukejee.lushandroidtaskapplication.feature.launch.model.Launch

class LaunchListRvAdapter() : RecyclerView.Adapter<LaunchListViewHolder>() {

    private  var launchList: MutableList<Launch> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchListViewHolder {
        val binding: ItemLaunchBinding = ItemLaunchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return LaunchListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaunchListViewHolder, position: Int) {
        val item = launchList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return launchList.size
    }

    fun replaceList(list: List<Launch>) {
        val diffCallBack = LaunchDiffCallBack(launchList, list)
        DiffUtil.calculateDiff(diffCallBack).dispatchUpdatesTo(this)
        launchList.apply { clear() }.addAll(list)
    }
}

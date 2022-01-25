package com.ukejee.lushandroidtaskapplication.feature.launch.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ukejee.lushandroidtaskapplication.feature.launch.model.Launch

class LaunchDiffCallBack(
    private val oldList: List<Launch>,
    private val newList: List<Launch>
) : DiffUtil.Callback(){

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}

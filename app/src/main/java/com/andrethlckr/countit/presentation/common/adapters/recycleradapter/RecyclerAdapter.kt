package com.andrethlckr.countit.presentation.common.adapters.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/*
* Universal recycler adapter for showing items in a list.
* You can adapt any object to a RecyclerItem like this:
*
* Thanks to Anton Stulnev, in https://medium.com/@fraggjkee/recyclerview-2020-a-modern-way-of-dealing-with-lists-in-android-using-databinding-d97abf5fb55f
* and https://medium.com/@fraggjkee/recyclerview-2020-a-modern-way-of-dealing-with-lists-in-android-using-databinding-part-2-df69f0a741f8
* */
class RecyclerAdapter : ListAdapter<RecyclerItem, BindingViewHolder>(DiffCallback()) {

    override fun getItemViewType(
        position: Int
    ): Int {
        return getItem(position).layoutId
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder,
        position: Int
    ) {
        getItem(position).bind(holder.binding)
        holder.binding.executePendingBindings()
    }
}

class BindingViewHolder(
    val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root)

private class DiffCallback : DiffUtil.ItemCallback<RecyclerItem>() {
    override fun areItemsTheSame(
        oldItem: RecyclerItem,
        newItem: RecyclerItem
    ): Boolean {
        return oldItem.comparator.isSameItem(newItem)
    }

    override fun areContentsTheSame(
        oldItem: RecyclerItem,
        newItem: RecyclerItem
    ): Boolean {
        return oldItem.comparator.isSameContent(newItem)
    }
}

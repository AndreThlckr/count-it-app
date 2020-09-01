package com.andrethlckr.countit.presentation.common.adapters.cashflowadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractBindingAdapter<T>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BindingViewHolder>(diffCallback) {

    abstract val layoutId: Int
    abstract val variableId: Int

    override fun getItemViewType(
        position: Int
    ): Int {
        return layoutId
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
        holder.binding.setVariable(variableId, getItem(position))
        holder.binding.executePendingBindings()
    }
}

class BindingViewHolder(
    val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root)

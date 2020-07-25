package com.andrethlckr.countit.presentation.adapters.recycleradapter

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.andrethlckr.countit.presentation.adapters.recycleradapter.comparators.RecyclerItemComparator

class RecyclerItem(
    val data: Any,
    @LayoutRes val layoutId: Int,
    val variableId: Int,
    val comparator: RecyclerItemComparator
) {
    fun bind(binding: ViewDataBinding) {
        binding.setVariable(variableId, data)
    }
}
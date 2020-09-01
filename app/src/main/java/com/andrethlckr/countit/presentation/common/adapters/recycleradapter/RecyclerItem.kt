package com.andrethlckr.countit.presentation.common.adapters.recycleradapter

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

class RecyclerItem(
    val data: Any,
    @LayoutRes val layoutId: Int,
    val variableId: Int
) {
    fun bind(binding: ViewDataBinding) {
        binding.setVariable(variableId, data)
    }
}

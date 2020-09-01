package com.andrethlckr.countit.presentation.common.adapters.cashflowadapter

import androidx.recyclerview.widget.DiffUtil
import com.andrethlckr.countit.BR
import com.andrethlckr.countit.R

class CashFlowAdapter : AbstractBindingAdapter<CashFlowItemViewModel>(DiffCallback()) {
    override val layoutId = R.layout.cash_flow_item
    override val variableId = BR.cashFlow
}

private class DiffCallback : DiffUtil.ItemCallback<CashFlowItemViewModel>() {
    override fun areItemsTheSame(
        oldItem: CashFlowItemViewModel,
        newItem: CashFlowItemViewModel
    ): Boolean {
        return oldItem.cashFlow.id == newItem.cashFlow.id
    }

    override fun areContentsTheSame(
        oldItem: CashFlowItemViewModel,
        newItem: CashFlowItemViewModel
    ): Boolean {
        return oldItem.cashFlow == newItem.cashFlow
    }
}

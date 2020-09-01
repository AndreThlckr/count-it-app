package com.andrethlckr.countit.presentation.common.adapters.cashflowadapter

import androidx.annotation.ColorRes
import com.andrethlckr.countit.R
import com.andrethlckr.countit.domain.cashflow.CashFlow
import java.text.NumberFormat
import kotlin.math.absoluteValue

class CashFlowItemViewModel(
    val cashFlow: CashFlow,
    private val onItemClick: ((CashFlow) -> Unit)? = null
) {
    val displayValue = NumberFormat.getCurrencyInstance().format(cashFlow.value.absoluteValue)
    @ColorRes val valueColor = if (cashFlow.isExpense()) R.color.colorError else R.color.colorSecondary
    val title = "${cashFlow.description} / ${cashFlow.origin}"
    val category = cashFlow.category
    val date = cashFlow.date

    fun onClick() {
        onItemClick?.invoke(cashFlow)
    }
}

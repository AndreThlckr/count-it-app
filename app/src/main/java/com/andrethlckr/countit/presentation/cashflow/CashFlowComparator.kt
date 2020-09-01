package com.andrethlckr.countit.presentation.cashflow

import com.andrethlckr.countit.domain.cashflow.CashFlow
import com.andrethlckr.countit.presentation.common.adapters.recycleradapter.RecyclerItem

class CashFlowComparator(
    val data: CashFlow
) : RecyclerItemComparator {
    override fun isSameItem(other: RecyclerItem): Boolean {
        if (data === other.data) return true
        if (data.javaClass != other.data.javaClass) return false

        other.data as CashFlow

        return data.id == other.data.id
    }

    override fun isSameContent(other: RecyclerItem): Boolean {
        other.data as CashFlow

        if (data.id != other.data.id) return false
        if (data.value != other.data.value) return false
        if (data.date != other.data.date) return false
        if (data.origin != other.data.origin) return false
        if (data.category != other.data.category) return false
        if (data.description != other.data.description) return false

        return true
    }
}

package com.andrethlckr.countit.presentation.cashflow.cashflowlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andrethlckr.countit.BR
import com.andrethlckr.countit.R
import com.andrethlckr.countit.domain.cashflow.CashFlow
import com.andrethlckr.countit.presentation.cashflow.CashFlowComparator
import com.andrethlckr.countit.presentation.common.adapters.recycleradapter.RecyclerItem
import java.util.GregorianCalendar

class CashFlowListViewModel @ViewModelInject constructor() : ViewModel() {
    private val _data = MutableLiveData<List<RecyclerItem>>()
    val data: LiveData<List<RecyclerItem>>
        get() = _data

    init {
        loadData()
    }

    private fun loadData() {
        val item = CashFlow(
            value = 30F,
            date = GregorianCalendar(2020, 6, 15),
            origin = "Lanchonete",
            category = "Comida",
            description = "Lanches"
        )

        val list = listOf(item)

        _data.value = list.map { it.toRecyclerItem() }
    }

    private fun CashFlow.toRecyclerItem() = RecyclerItem(
        data = this,
        variableId = BR.cashFlow,
        layoutId = R.layout.cash_flow_item,
        comparator = CashFlowComparator(
            this
        )
    )
}

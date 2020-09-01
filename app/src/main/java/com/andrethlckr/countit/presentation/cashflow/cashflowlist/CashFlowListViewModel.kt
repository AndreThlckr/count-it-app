package com.andrethlckr.countit.presentation.cashflow.cashflowlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.andrethlckr.countit.BR
import com.andrethlckr.countit.R
import com.andrethlckr.countit.domain.cashflow.CashFlow
import com.andrethlckr.countit.domain.usecase.getcashflows.GetCashFlowsResult
import com.andrethlckr.countit.domain.usecase.getcashflows.GetCashFlowsUseCase
import com.andrethlckr.countit.presentation.cashflow.CashFlowComparator
import com.andrethlckr.countit.presentation.common.adapters.cashflowadapter.CashFlowItemViewModel
import com.andrethlckr.countit.presentation.common.adapters.recycleradapter.RecyclerItem
import kotlinx.coroutines.flow.collect

class CashFlowListViewModel @ViewModelInject constructor(
    private val getCashFlowsUseCase: GetCashFlowsUseCase
) : ViewModel() {
    val cashflows = liveData {
        getCashFlowsUseCase.invoke().collect { result ->
            when (result) {
                is GetCashFlowsResult.Success -> this.emit(result.cashFlows.toCashFlowItemViewModel())
                is GetCashFlowsResult.Failure.Unexpected -> _shouldShowError.postValue(R.string.unexpected_error)
            }
        }
    }

    private val _shouldShowSnackBar = MutableLiveData<String>()
    val shouldShowSnackBar: LiveData<String> = _shouldShowSnackBar

    private val _shouldShowError = MutableLiveData<Int>()
    val shouldShowError: LiveData<Int> = _shouldShowError

    private fun CashFlow.toRecyclerItem() = RecyclerItem(
        data = this,
        variableId = BR.cashFlow,
        layoutId = R.layout.cash_flow_item,
        comparator = CashFlowComparator(
            this
        )
    )

    private fun List<CashFlow>.toRecyclerItems() = this.map { it.toRecyclerItem() }

    private fun List<CashFlow>.toCashFlowItemViewModel() = this.map {
        CashFlowItemViewModel(it) { cashFlow ->
            _shouldShowSnackBar.postValue(cashFlow.description)
        }
    }
}

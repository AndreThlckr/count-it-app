package com.andrethlckr.countit.domain.cashflow

import com.andrethlckr.countit.domain.common.resource.Resource
import kotlinx.coroutines.flow.Flow

interface CashFlowRepository {
    fun getCashFlows() : Flow<Resource<List<CashFlow>>>
}

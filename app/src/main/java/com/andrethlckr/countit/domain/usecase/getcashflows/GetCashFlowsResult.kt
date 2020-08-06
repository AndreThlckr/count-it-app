package com.andrethlckr.countit.domain.usecase.getcashflows

import com.andrethlckr.countit.domain.cashflow.CashFlow
import com.andrethlckr.countit.domain.common.resource.DomainFailure

sealed class GetCashFlowsResult {
    data class Success(val cashFlows: List<CashFlow>) : GetCashFlowsResult()

    sealed class Failure : GetCashFlowsResult() {
        class Unexpected(val domainFailure: DomainFailure) : Failure()
    }
}

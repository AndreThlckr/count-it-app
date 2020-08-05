package com.andrethlckr.countit.domain.usecase.getcashflows

import com.andrethlckr.countit.domain.cashflow.CashFlow
import com.andrethlckr.countit.domain.cashflow.CashFlowRepository
import com.andrethlckr.countit.domain.common.resource.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class GetCashFlowUseCaseImpl(
    private val cashFlowRepository: CashFlowRepository
) : GetCashFlowsUseCase {
    @ExperimentalCoroutinesApi
    override fun invoke(): Flow<GetCashFlowsResult> = flow {
        cashFlowRepository.getCashFlows().collect {
            emit(it.toResult())
        }
    }

    private fun Resource<List<CashFlow>>.toResult() =
        when (this) {
            is Resource.Loading -> GetCashFlowsResult.Loading
            is Resource.Success -> GetCashFlowsResult.Success(this.data)
            is Resource.Error -> this.toFailure()
        }

    private fun Resource.Error.toFailure() =
        GetCashFlowsResult.Failure.Unexpected(this.domainFailure)
}

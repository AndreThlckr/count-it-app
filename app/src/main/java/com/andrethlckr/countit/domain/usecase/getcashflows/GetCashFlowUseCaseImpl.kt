package com.andrethlckr.countit.domain.usecase.getcashflows

import com.andrethlckr.countit.domain.cashflow.CashFlowRepository
import com.andrethlckr.countit.domain.common.resource.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

class GetCashFlowUseCaseImpl(
    private val cashFlowRepository: CashFlowRepository
) : GetCashFlowsUseCase {
    @ExperimentalCoroutinesApi
    override fun invoke(): Flow<GetCashFlowsResult> = flow {
            cashFlowRepository.getCashFlows().collect {
                emit(
                    when(it) {
                        is Resource.Loading -> GetCashFlowsResult.Loading
                        is Resource.Success -> GetCashFlowsResult.Success(it.data)
                        is Resource.Error -> GetCashFlowsResult.Failure.Unexpected(it.domainFailure)
                    }
                )
            }
        }
    }
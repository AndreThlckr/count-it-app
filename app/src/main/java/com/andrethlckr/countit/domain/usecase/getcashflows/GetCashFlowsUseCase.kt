package com.andrethlckr.countit.domain.usecase.getcashflows

import kotlinx.coroutines.flow.Flow

interface GetCashFlowsUseCase {
    fun invoke(): Flow<GetCashFlowsResult>
}
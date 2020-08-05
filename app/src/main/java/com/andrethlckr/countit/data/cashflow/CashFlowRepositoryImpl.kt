package com.andrethlckr.countit.data.cashflow

import com.andrethlckr.countit.data.cashflow.source.firestore.FirestoreCashFlow
import com.andrethlckr.countit.data.cashflow.source.firestore.FirestoreCashFlowDataSource
import com.andrethlckr.countit.domain.cashflow.CashFlow
import com.andrethlckr.countit.domain.cashflow.CashFlowRepository
import com.andrethlckr.countit.domain.common.mapper.AbstractMapper
import com.andrethlckr.countit.domain.common.resource.ErrorHandler
import com.andrethlckr.countit.domain.common.resource.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CashFlowRepositoryImpl @Inject constructor(
    private val firestoreDataSource: FirestoreCashFlowDataSource,
    private val mapper: AbstractMapper<CashFlow, FirestoreCashFlow>,
    private val errorHandler: ErrorHandler,
    private val dispatcher: CoroutineDispatcher
) : CashFlowRepository {

    @ExperimentalCoroutinesApi
    override fun getCashFlows(): Flow<Resource<List<CashFlow>>> {
        return firestoreDataSource.getCashFlows().map { list ->
            Resource.Success(list.toCashFlows())
        }.catch { cause ->
            Resource.Error(
                errorHandler.getFailure(cause)
            )
        }
            .flowOn(dispatcher)
            .conflate()
    }

    private fun List<FirestoreCashFlow>.toCashFlows(): List<CashFlow> {
        return mapper.mapToEntity(this)
    }
}

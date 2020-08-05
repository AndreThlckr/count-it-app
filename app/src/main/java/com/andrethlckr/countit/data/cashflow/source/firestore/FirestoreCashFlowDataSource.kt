package com.andrethlckr.countit.data.cashflow.source.firestore

import kotlinx.coroutines.flow.Flow

interface FirestoreCashFlowDataSource {
    fun getCashFlows(): Flow<List<FirestoreCashFlow>>
}

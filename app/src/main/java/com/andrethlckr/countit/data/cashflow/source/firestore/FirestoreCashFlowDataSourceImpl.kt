package com.andrethlckr.countit.data.cashflow.source.firestore

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FirestoreCashFlowDataSourceImpl @Inject constructor() : FirestoreCashFlowDataSource {
    override fun getCashFlows(): Flow<List<FirestoreCashFlow>> {
        TODO("Not yet implemented")
    }
}

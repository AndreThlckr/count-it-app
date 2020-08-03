package com.andrethlckr.countit.data.cashflow.source.firestore

import com.andrethlckr.countit.domain.common.mapper.AbstractMapper
import com.andrethlckr.countit.domain.cashflow.CashFlow
import javax.inject.Inject

class FirestoreCashFlowMapper @Inject constructor() : AbstractMapper<CashFlow, FirestoreCashFlow>() {
    override fun mapToEntity(data: FirestoreCashFlow) = CashFlow(
        id = data.id,
        value = data.value,
        date = data.date,
        origin = data.origin,
        category = data.category,
        description = data.description
    )

    override fun mapToData(entity: CashFlow) = FirestoreCashFlow(
        id = entity.id,
        value = entity.value,
        date = entity.date,
        origin = entity.origin,
        category = entity.category,
        description = entity.description
    )
}
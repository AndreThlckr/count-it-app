package com.andrethlckr.countit.data.cashflow.source.firestore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.GregorianCalendar
import java.util.UUID
import javax.inject.Inject

class FirestoreCashFlowDataSourceImpl @Inject constructor() : FirestoreCashFlowDataSource {
    override fun getCashFlows(): Flow<List<FirestoreCashFlow>> {
        // Fake implementation

        val cf1 = FirestoreCashFlow(
            id = UUID.randomUUID().toString(),
            value = -30.0,
            date = GregorianCalendar(2020, 6, 15),
            origin = "Lanchonete",
            category = "Comida",
            description = "Lanches"
        )

        val cf2 = FirestoreCashFlow(
            id = UUID.randomUUID().toString(),
            value = 38.0,
            date = GregorianCalendar(2020, 6, 17),
            origin = "Odete",
            category = "Telas",
            description = "Pagamento das telas da Odete"
        )

        val cf3 = FirestoreCashFlow(
            id = UUID.randomUUID().toString(),
            value = -8.0,
            date = GregorianCalendar(2020, 6, 18),
            origin = "Felippi",
            category = "Higiene",
            description = "Sabonete com cheiro de isopor"
        )

        return flowOf(listOf(cf1), listOf(cf1, cf2), listOf(cf1, cf2, cf3))
    }
}

package com.andrethlckr.countit.data.cashflow.source.firestore

import com.andrethlckr.countit.domain.cashflow.CashFlow
import com.andrethlckr.countit.domain.common.mapper.AbstractMapper
import com.andrethlckr.countit.toUUID
import com.google.firebase.Timestamp
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.time.LocalDate

class FirestoreCashFlowMapperTest {

    private val mapper: AbstractMapper<CashFlow, FirestoreCashFlow> = FirestoreCashFlowMapper()

    @Test
    fun `mapToEntity should return CashFlow when given a FirestoreCashFlow`() {
        val firestoreCashFlow = FirestoreCashFlow(
            id = 1.toUUID().toString(),
            value = 20.0,
            date = Timestamp(946684800, 0),
            origin = "Lanchonete",
            category = "Alimentação",
            description = "4x lanches"
        )

        val actualCashFlow = mapper.mapToEntity(firestoreCashFlow)

        val expectedCashFlow = CashFlow(
            id = 1.toUUID().toString(),
            value = 20.0,
            date = LocalDate.of(2000, 1, 1),
            origin = "Lanchonete",
            category = "Alimentação",
            description = "4x lanches"
        )
        actualCashFlow shouldBe expectedCashFlow
    }

    @Test
    fun `mapToData should return FirestoreCashFlow when given a CashFlow`() {
        val cashFlow = CashFlow(
            id = 1.toUUID().toString(),
            value = 20.0,
            date = LocalDate.of(2000, 1, 1),
            origin = "Lanchonete",
            category = "Alimentação",
            description = "4x lanches"
        )

        val actualFirestoreCashFlow = mapper.mapToData(cashFlow)

        val expectedFirestoreCashFlow = FirestoreCashFlow(
            id = 1.toUUID().toString(),
            value = 20.0,
            date = Timestamp(946684800, 0),
            origin = "Lanchonete",
            category = "Alimentação",
            description = "4x lanches"
        )
        actualFirestoreCashFlow shouldBe expectedFirestoreCashFlow
    }
}

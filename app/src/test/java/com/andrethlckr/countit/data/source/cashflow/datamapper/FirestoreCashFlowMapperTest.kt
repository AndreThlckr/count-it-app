package com.andrethlckr.countit.data.source.cashflow.datamapper

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FirestoreCashFlowMapperTest {
    private val dependencyExample = String().apply {
        this.capitalize()
    }

    init {
        // Poderia usar aqui, também
    }

    @BeforeEach
    fun resetFields() {
        // reset fields here
    }

    @Test
    fun map() {
    }
}

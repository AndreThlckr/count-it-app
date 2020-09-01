package com.andrethlckr.countit.domain.cashflow

import java.text.NumberFormat
import java.time.LocalDate
import java.util.UUID
import kotlin.math.absoluteValue

data class CashFlow(
    val id: String = UUID.randomUUID().toString(),
    val value: Double,
    val date: LocalDate,
    val origin: String,
    val category: String = "",
    val description: String = ""
) {
    val formattedValue: String
        get() = NumberFormat.getCurrencyInstance().format(value.absoluteValue)

    fun isExpense() = value < 0

    fun isIncome() = value > 0
}

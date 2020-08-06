package com.andrethlckr.countit.domain.cashflow

import java.util.GregorianCalendar
import java.util.UUID

data class CashFlow(
    val id: String = UUID.randomUUID().toString(),
    val value: Double,
    val date: GregorianCalendar,
    val origin: String,
    val category: String = "",
    val description: String = ""
) {
    val formattedValue: String
        get() = "R$$value"

    fun isExpense() = value < 0

    fun isIncome() = value > 0
}

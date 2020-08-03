package com.andrethlckr.countit.domain.cashflow

import java.util.*

class CashFlow(
    val id: String = UUID.randomUUID().toString(),
    val value: Float,
    val date: GregorianCalendar,
    val origin: String,
    val category: String = "",
    val description: String = ""
){
    val formattedValue: String
        get() = "R$$value"

    fun isExpense() = value < 0

    fun isIncome() = value > 0
}
package com.andrethlckr.countit.domain.models

import java.util.*

class CashFlow(
    val value: Float,
    val date: GregorianCalendar,
    val origin: String,
    val category: String,
    val description: String
){
    val formattedValue: String
        get() = "R$$value"

    fun isExpense() = value < 0

    fun isIncome() = value > 0
}
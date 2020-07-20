package com.andrethlckr.countit.data.source.cashflow.firestore

import com.google.firebase.firestore.DocumentId
import java.util.*

data class FirestoreCashFlow(
    @DocumentId val id: String,
    val value: Float,
    val date: GregorianCalendar,
    val origin: String,
    val category: String,
    val description: String
)
package com.andrethlckr.countit.data.cashflow.source.firestore

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId

data class FirestoreCashFlow(
    @DocumentId val id: String,
    val value: Double,
    val date: Timestamp,
    val origin: String,
    val category: String,
    val description: String
)

package com.andrethlckr.countit.data

import com.google.firebase.Timestamp
import java.time.LocalDate
import java.time.ZoneOffset
import java.util.Date

fun Timestamp.toLocalDate(): LocalDate = this.toDate().toInstant().atZone(ZoneOffset.UTC).toLocalDate()

fun LocalDate.toTimestamp() = Timestamp(Date.from(this.atStartOfDay(ZoneOffset.UTC).toInstant()))

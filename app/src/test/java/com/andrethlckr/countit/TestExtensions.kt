package com.andrethlckr.countit

import java.time.Instant
import java.util.*

fun Int.toInstant(): Instant
        = Instant.ofEpochSecond(this.toLong())

fun Int.toUUID(): UUID
        = UUID.fromString("00000000-0000-0000-a000-${this.toString().padStart(11, '0')}")
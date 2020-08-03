package com.andrethlckr.countit.domain.common.resource

interface ErrorHandler {
    fun getFailure(throwable: Throwable): DomainFailure
}
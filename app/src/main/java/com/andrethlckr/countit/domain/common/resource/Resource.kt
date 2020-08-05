package com.andrethlckr.countit.domain.common.resource

/**
 * Generic class for wrapping a repository resource.
 */
sealed class Resource<out T> {
    data class Loading<out T>(val data: T? = null) : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val domainFailure: DomainFailure) : Resource<Nothing>()
}

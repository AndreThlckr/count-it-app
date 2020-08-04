package com.andrethlckr.countit.domain.common.resource

/**
 * Generic class for defining an app failure.
 *
 * Generic failures should be avoided AT ALL COSTS, since they aren't expected by use cases.
 */
sealed class DomainFailure {
    object NetworkFailure : DomainFailure()
    object NotFoundFailure : DomainFailure()
    object AccessDeniedFailure : DomainFailure()
    object ServiceUnavailableFailure : DomainFailure()
    object Canceled : DomainFailure()
    class GenericFailure(val code: Int, val message: String) : DomainFailure()
}
package com.andrethlckr.countit.data

import com.andrethlckr.countit.domain.common.resource.DomainFailure
import com.andrethlckr.countit.domain.common.resource.ErrorHandler
import java.io.IOException
import javax.inject.Inject

/**
 * Class for handling errors from data layer and map them to a domain Failure.
 */
class ErrorHandlerImpl @Inject constructor() : ErrorHandler {

    /**
     * Returns a Failure for a respective Throwable.
     *
     * Example of retrofit error handling:
     *
     * <pre>
     *     is HttpException -> {
     *           when(val code = throwable.code()) {
     *              DataConstants.Network.HttpStatusCode.UNSATISFIABLE_REQUEST -> ErrorEntity.Network
     *              HttpURLConnection.HTTP_NOT_FOUND -> ErrorEntity.NotFound
     *              HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.AccessDenied
     *              HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable
     *              else -> Failure.GenericFailure(code, throwable.message.orEmpty())
     *           }
     *     }
     * </pre>
     *
     */
    override fun getFailure(throwable: Throwable): DomainFailure {
        return when (throwable) {
            is IOException -> DomainFailure.NetworkFailure
            else -> DomainFailure.GenericFailure(0, throwable.message.orEmpty())
        }
    }
}

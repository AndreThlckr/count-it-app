package com.andrethlckr.countit.domain.common.mapper

/*
* Abstract mapper for handling list mapping.
*
* Thanks to Denis Brandi, in https://proandroiddev.com/the-real-repository-pattern-in-android-efba8662b754
* */
abstract class AbstractMapper<E, D> : Mapper<E, D> {
    fun mapToEntity(input: List<D>): List<E> {
        return input.map { mapToEntity(it) }
    }

    fun mapToData(input: List<E>): List<D> {
        return input.map { mapToData(it) }
    }
}
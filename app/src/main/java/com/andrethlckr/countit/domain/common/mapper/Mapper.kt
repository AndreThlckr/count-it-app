package com.andrethlckr.countit.domain.common.mapper

interface Mapper<E, D> {
    fun mapToEntity(data: D): E
    fun mapToData(entity: E): D
}
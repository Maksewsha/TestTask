package ru.maksewsha.testtask.domain.utils

interface EntityMapper<F, T> {
    fun mapFromEntity(entity: F): T
}
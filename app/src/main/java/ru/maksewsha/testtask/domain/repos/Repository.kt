package ru.maksewsha.testtask.domain.repos

interface Repository {
    suspend fun fetchData(): Any
}
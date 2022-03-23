package ru.maksewsha.testtask.domain.usecases

import ru.maksewsha.testtask.data.network.NetworkRepository
import ru.maksewsha.testtask.data.network.RetrofitService

class GetCharactersListUseCase(private val networkRepository: NetworkRepository) {
    suspend fun execute() = networkRepository.fetchData()

}
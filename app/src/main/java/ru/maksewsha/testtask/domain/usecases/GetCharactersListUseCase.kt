package ru.maksewsha.testtask.domain.usecases

class GetCharactersListUseCase(private val repository: Repository) {
    suspend fun execute() = repository.fetchData()

}

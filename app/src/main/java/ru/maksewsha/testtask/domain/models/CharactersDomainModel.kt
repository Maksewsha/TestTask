package ru.maksewsha.testtask.domain.models

sealed class CharactersDomainModel {
    class Success(val data: List<CharacterDomain>) : CharactersDomainModel()
    class Fail(val errorMessage: String): CharactersDomainModel()
}
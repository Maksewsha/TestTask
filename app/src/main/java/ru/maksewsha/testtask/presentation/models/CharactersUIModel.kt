package ru.maksewsha.testtask.presentation.models

sealed class CharactersUIModel {
    class Success(val data: List<CharacterPresentation>): CharactersUIModel()
    class Fail(val errorMessage: String): CharactersUIModel()
}
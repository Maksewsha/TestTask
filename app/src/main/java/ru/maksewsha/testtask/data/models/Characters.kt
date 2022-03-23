package ru.maksewsha.testtask.data.models

sealed class Characters {
    class Success(val data: List<Character>) : Characters()
    class Fail(val errorMessage: String): Characters()
}
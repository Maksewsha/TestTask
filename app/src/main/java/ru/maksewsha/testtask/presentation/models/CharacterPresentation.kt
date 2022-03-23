package ru.maksewsha.testtask.presentation.models

data class CharacterPresentation(
    val charId: Int,
    val name: String,
    val birthday: String,
    val occupation: List<String>,
    val img: String,
    val status: String,
    val appearance: List<Int>,
    val nickname: String,
    val portrayed: String
) {
}
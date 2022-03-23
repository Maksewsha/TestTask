package ru.maksewsha.testtask.data.models

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("char_id")
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
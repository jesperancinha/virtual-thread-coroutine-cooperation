package org.jesperancinha.vtcc

import java.time.LocalDate

enum class Personality {
    Curious,
    Friendly,
    Adventurous
}

data class Goose(
    val name: String,
    val birthDate: LocalDate,
    val personality: Personality
)

data class Person(val name: String, val age: Int)


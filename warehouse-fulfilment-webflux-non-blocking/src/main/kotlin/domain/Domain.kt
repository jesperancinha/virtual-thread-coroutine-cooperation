package org.jesperancinha.domain

import java.util.*

enum class IsleType {
    Kitchen,
    Room,
    Garden,
    Misc
}
data class Product(
    val id:UUID  = UUID.randomUUID(),
    val name: String,
    val isleType: IsleType
)
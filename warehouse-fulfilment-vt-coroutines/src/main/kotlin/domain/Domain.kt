package org.jesperancinha.domain

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface ProductDao : ReactiveCrudRepository<Product, UUID>

enum class IsleType {
    Kitchen,
    Room,
    Garden,
    Misc
}

data class Product(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val isleType: IsleType
)

data class Message(
    val message: String
)

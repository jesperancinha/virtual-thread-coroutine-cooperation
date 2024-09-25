package org.jesperancinha.domain

import org.springframework.data.annotation.Id
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductDao: CrudRepository<Product, UUID>

enum class IsleType {
    Kitchen,
    Room,
    Garden,
    Misc
}
data class Product(
    @Id
    val id:UUID  = UUID.randomUUID(),
    val name: String,
    val isleType: IsleType
)
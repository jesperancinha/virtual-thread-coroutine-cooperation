package org.jesperancinha.vtcc.domain

import org.springframework.data.annotation.Id
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

interface ProductDao: CoroutineCrudRepository<Product, UUID>

enum class IsleType {
    Kitchen,
    Room,
    Garden,
    Misc
}
data class Product(
    @Id
    var id:UUID? = null,
    val name: String,
    val isleType: IsleType? = null
)

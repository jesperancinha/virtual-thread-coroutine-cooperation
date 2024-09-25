package org.jesperancinha.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductDao: JpaRepository<Product, UUID>

enum class IsleType {
    Kitchen,
    Room,
    Garden,
    Misc
}

@Entity
@Table(name = "product")
data class Product(
    @Id
    val id:UUID  = UUID.randomUUID(),
    val name: String,
    @Enumerated(EnumType.STRING)
    val isleType: IsleType
)
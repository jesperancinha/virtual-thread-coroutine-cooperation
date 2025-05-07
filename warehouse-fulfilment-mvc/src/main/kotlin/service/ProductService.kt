package org.jesperancinha.service

import org.jesperancinha.domain.Product
import org.jesperancinha.domain.ProductDao
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductService(
    private val productDao: ProductDao
) {
    fun getAllItems(): List<Product> = productDao.findAll()
    fun getItemById(uUID: UUID): Product? = productDao.findByIdOrNull(uUID)
}
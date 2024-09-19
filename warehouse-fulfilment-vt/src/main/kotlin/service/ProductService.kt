package org.jesperancinha.service

import org.jesperancinha.domain.ProductDao
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductService(
    private val productDao: ProductDao
) {
    fun getAllItems() = productDao.findAll()
    fun getItemById(uUID: UUID) = productDao.findById(uUID)
}
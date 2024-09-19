package org.jesperancinha.service

import org.jesperancinha.domain.ProductDao
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FulfilmentService (val productDao: ProductDao) {
    fun getAllItems() = productDao.findAll()
    suspend fun getItemById(uUID: UUID) = productDao.findById(uUID)
}
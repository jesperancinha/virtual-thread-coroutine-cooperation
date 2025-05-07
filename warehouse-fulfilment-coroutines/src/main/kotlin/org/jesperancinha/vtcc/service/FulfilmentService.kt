package org.jesperancinha.vtcc.service

import org.jesperancinha.vtcc.domain.Product
import org.jesperancinha.vtcc.domain.ProductDao
import org.springframework.stereotype.Service
import java.util.*

@Service
class FulfilmentService (val productDao: ProductDao) {
    fun getAllItems() = productDao.findAll()
    suspend fun getItemById(uUID: UUID): Product? = productDao.findById(uUID)
    suspend fun save(item: Product) = productDao.save(item)
}
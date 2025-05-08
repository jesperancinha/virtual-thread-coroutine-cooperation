package org.jesperancinha.service

import org.jesperancinha.domain.Product
import org.jesperancinha.domain.ProductDao
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class ProductService(
    private val productDao: ProductDao
) {
    fun getAllItems(): Flux<Product> = productDao.findAll()
    fun getItemById(uUID: UUID): Mono<Product> = productDao.findById(uUID)
}

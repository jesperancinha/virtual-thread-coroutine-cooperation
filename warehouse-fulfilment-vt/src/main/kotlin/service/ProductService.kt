package org.jesperancinha.service

import org.jesperancinha.domain.ProductDao
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.concurrent.Executors

@Service
class ProductService(
    private val productDao: ProductDao
) {
    fun getAllItems() = productDao.findAll()
    fun getItemById(uUID: UUID) = productDao.findByIdOrNull(uUID)
}

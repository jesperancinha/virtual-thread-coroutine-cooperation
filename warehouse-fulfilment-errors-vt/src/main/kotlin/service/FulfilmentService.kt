package org.jesperancinha.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.jesperancinha.domain.IsleType.Room
import org.jesperancinha.domain.Product
import org.springframework.stereotype.Service

@Service
class FulfilmentService {

    private val objectMapper = ObjectMapper().registerModule(kotlinModule())

    fun process(): List<Product> {
        val products = (1..1000).map {
            Product(name = "TV", isleType = Room)
        }
        val json = objectMapper.writeValueAsString(products)
        return objectMapper.readValue<List<Product>>(json)

    }
}

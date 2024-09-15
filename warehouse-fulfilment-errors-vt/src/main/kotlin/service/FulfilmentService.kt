package org.jesperancinha.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.jesperancinha.domain.IsleType.Room
import org.jesperancinha.domain.Product
import org.springframework.stereotype.Service

@Service
class FulfilmentService {

    private val objectMapper = ObjectMapper().registerModule(kotlinModule())

    fun process(): String {
        val product = Product(name = "TV", isleType = Room)

        try {
            val json = objectMapper.writeValueAsString(product)
            println("Serialized JSON: $json")

            val deserializedPerson = objectMapper.readValue(json, Product::class.java)
            println("Deserialized Person: $deserializedPerson")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "Done"
    }
}

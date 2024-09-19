package org.jesperancinha.controller

import org.jesperancinha.service.ProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("fulfilment")
class FulfilmentController(
    private val productService: ProductService,
) {

    @GetMapping
    fun getItems() = productService.getAllItems()

    @GetMapping("{id}")
    suspend fun getItem(@PathVariable id: UUID) = productService.getItemById(id)

    companion object {
        val logger: Logger = LoggerFactory.getLogger(FulfilmentController::class.java)
    }
}
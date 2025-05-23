package org.jesperancinha.vtcc.controller

import kotlinx.coroutines.flow.Flow
import org.jesperancinha.vtcc.domain.Product
import org.jesperancinha.vtcc.service.FulfilmentService
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
    val fulfilmentService: FulfilmentService
) {

    @GetMapping
    fun getItems(): Flow<Product> = fulfilmentService.getAllItems()

    @GetMapping("{id}")
    suspend fun getItem(@PathVariable id: UUID): Product? = fulfilmentService.getItemById(id)

    companion object {
        val logger: Logger = LoggerFactory.getLogger(FulfilmentController::class.java)
    }
}
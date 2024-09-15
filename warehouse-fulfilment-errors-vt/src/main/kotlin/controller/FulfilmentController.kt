package org.jesperancinha.controller

import org.jesperancinha.domain.IsleType.Room
import org.jesperancinha.domain.Product
import org.jesperancinha.service.FulfilmentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("fulfilment")
class FulfilmentController(
    val fulfilmentService: FulfilmentService
) {

    @GetMapping
    fun getItems() = (1..10).map {
        val product = Product(name = "TV", isleType = Room)
        logger.info("Product: $product")
        product.name
    }

    @GetMapping("process")
    fun processDate() = fulfilmentService.process()

    companion object {
        val logger: Logger = LoggerFactory.getLogger(FulfilmentController::class.java)
    }
}
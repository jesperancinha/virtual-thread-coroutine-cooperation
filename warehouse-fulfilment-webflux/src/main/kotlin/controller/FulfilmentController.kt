package org.jesperancinha.controller

import org.jesperancinha.domain.IsleType.Room
import org.jesperancinha.domain.Product
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.lang.Thread.sleep
import java.time.Duration
import kotlin.time.Duration.Companion.milliseconds

@RestController
@RequestMapping("fulfilment")
class FulfilmentController {

    @GetMapping
    fun getItems(): Flux<String> = Flux.fromStream((1..10).toSet().stream())
        .map {
            val product = Product(name = "TV", isleType = Room)
            logger.info("Product: $product")
            product.name
        }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(FulfilmentController::class.java)
    }
}
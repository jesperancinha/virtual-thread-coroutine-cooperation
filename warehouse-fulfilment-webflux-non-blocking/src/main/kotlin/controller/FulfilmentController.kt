package org.jesperancinha.controller

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jesperancinha.domain.IsleType.Room
import org.jesperancinha.domain.Product
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("fulfilment")
class FulfilmentController {


    @OptIn(DelicateCoroutinesApi::class)
    fun nonBlockingLog(message: String) {
        GlobalScope.launch(Dispatchers.IO) {
            logger.info(message)
        }
    }

    @GetMapping
    fun getItems(): Flux<String> = Flux.fromStream((1..10).toSet().stream())
        .map {
            val product = Product(name = "TV", isleType = Room)
            nonBlockingLog("Product: $product")
            product.name
        }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(FulfilmentController::class.java)
    }
}
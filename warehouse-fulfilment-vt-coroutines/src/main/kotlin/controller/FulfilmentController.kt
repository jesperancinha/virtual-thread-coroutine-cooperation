package org.jesperancinha.controller

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import org.jesperancinha.domain.IsleType.Room
import org.jesperancinha.domain.Product
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cglib.proxy.Dispatcher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Thread.sleep
import java.util.concurrent.Executors
import kotlin.time.Duration.Companion.milliseconds
import reactor.core.publisher.Flux

@RestController
@RequestMapping("fulfilment")
class FulfilmentController {

    @GetMapping
    fun getItems() = flow {
        repeat(10) {
            val product = Product(name = "TV", isleType = Room)
            logger.info("Product: $product")
            emit(product.name)
        }
    }.flowOn(
        Executors.newVirtualThreadPerTaskExecutor()
            .asCoroutineDispatcher()
    )

    @GetMapping("control")
    fun getItemsTest() = flowOf(1..10).map {
        val product = Product(name = "TV", isleType = Room)
        logger.info("Product: $product")
        product.name
    }


    companion object {
        val logger: Logger = LoggerFactory.getLogger(FulfilmentController::class.java)
    }
}
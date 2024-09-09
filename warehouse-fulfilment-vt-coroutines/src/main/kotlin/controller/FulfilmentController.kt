package org.jesperancinha.controller

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import org.jesperancinha.domain.IsleType.Room
import org.jesperancinha.domain.Message
import org.jesperancinha.domain.Product
import org.jesperancinha.vtcc.MessageSender
import org.jesperancinha.vtcc.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.concurrent.Executors

@RestController
@RequestMapping("fulfilment")
class FulfilmentController(
    val messageSender: MessageSender,
    val userService: UserService
) {

    @GetMapping
    fun getItems(): Flow<String> = (1..10).asFlow().map {
        val product = Product(name = "TV", isleType = Room)
        logger.info("Product: $product")
        product.name
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

    @PostMapping(
        path = ["messages"], consumes = [APPLICATION_JSON_VALUE],
        produces = [APPLICATION_JSON_VALUE],
    )
    fun sendMessage(@RequestBody message: Message) =
        messageSender.sendMessage(message.message)

    @GetMapping("users/{id}")
    suspend fun processUserData(@PathVariable id:Long) = userService.loadUserData(id)
        .run { UUID.randomUUID() }

    @GetMapping("allUsers")
    fun getAllUsers() = userService.getAllUsers()

    companion object {
        val logger: Logger = LoggerFactory.getLogger(FulfilmentController::class.java)
    }
}
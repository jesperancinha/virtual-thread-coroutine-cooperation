package org.jesperancinha.vtcc

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.Thread.sleep
import java.util.*
import kotlin.random.Random

val logger: Logger = LoggerFactory.getLogger(User::class.java)
val random = java.util.Random()
data class User(val id: Long, val name: String, val email: String)

fun sendMessage(text: String, users: List<User>) = users.chunked(50).map {
    Thread.startVirtualThread {
        it.map {
            Thread.startVirtualThread {
                retry(5, 500) {
                    sendEmail(text, it)
                }
            }
        }.forEach { it.join() }
    }
}

fun <T> retry(maxRetries: Int, delayMillis: Long, block: () -> T): T {
    var lastException: Exception? = null
    repeat(maxRetries) {
        try {
            return block()
        } catch (e: Exception) {
            lastException = e
            sleep(delayMillis)
            logger.warn("Retry number: $it - Retrying ...")
        }
    }
    throw lastException ?: IllegalStateException("Retry failed with no exception")
}


fun sendEmail(message: String, user: User) {
    sleep(1000)
    random.nextBoolean().takeIf { it }
        ?: random.nextBoolean().takeIf { it }
        ?: throw RuntimeException()
    logger.info("sent to user $user")
}

fun main() {
    sendMessage("This is a message", (1..100).map {
        User(
            id = Random.nextLong(), name = "user-${UUID.randomUUID()}", email = "user-${UUID.randomUUID()}"
        )
    }).forEach { it.join() }
}

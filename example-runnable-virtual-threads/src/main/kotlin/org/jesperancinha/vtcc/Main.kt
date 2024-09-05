package org.jesperancinha.vtcc

import org.jesperancinha.vtcc.MessageSender.Companion.logger
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.Thread.sleep
import java.lang.Thread.startVirtualThread
import java.util.*
import kotlin.random.Random

data class User(val id: Long, val name: String, val email: String)

class MessageSender {

    fun sendMessage(text: String, users: List<User>) = users.chunked(50).map {
            it.map {
                startVirtualThread {
                    retry(5, 500) {
                        sendEmail(text, it)
                    }
                }
            }.forEach { it.join() }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(User::class.java)
        private val random = java.util.Random()

        fun sendEmail(message: String, user: User) {
            sleep(1000)
            random.nextBoolean().takeIf { it }
                ?: random.nextBoolean().takeIf { it }
                ?: throw RuntimeException()
            logger.info("sent message $message to user $user")
        }
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


fun main() {
    val messageSender = MessageSender()
    logger.info("Starting to send messages")
    messageSender.sendMessage("This is a message", (1..100).map {
        User(
            id = Random.nextLong(), name = "user-${UUID.randomUUID()}", email = "user-${UUID.randomUUID()}"
        )
    })
}

package org.jesperancinha

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.Thread.sleep
import java.util.*
import kotlin.random.Random

val logger: Logger = LoggerFactory.getLogger(User::class.java)

data class User(val id: Long, val name: String, val email: String)

fun sendMessage(text: String, users: List<User>) = users.chunked(50).map {
    Thread.startVirtualThread {
        it.map {
            Thread.startVirtualThread { sendEmail(text, it) }
        }.forEach { it.join() }
    }
}


fun sendEmail(message: String, user: User) {
    sleep(1000)
    logger.info("sent to user $user")
}

fun main() {
    sendMessage("This is a message", (1..100).map {
        User(
            id = Random.nextLong(), name = "user-${UUID.randomUUID()}", email = "user-${UUID.randomUUID()}"
        )
    }).forEach { it.join() }
}

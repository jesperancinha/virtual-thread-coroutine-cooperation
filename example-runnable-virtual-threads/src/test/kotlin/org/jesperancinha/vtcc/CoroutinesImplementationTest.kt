package org.jesperancinha.vtcc

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.jesperancinha.vtcc.MessageSender.Companion.sendEmail
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.random.Random


class MessageSenderCoroutines {

    suspend fun sendMessage(text: String, users: List<User>) = coroutineScope {
        users.chunked(50).map {
            it.map {
                async {
                    retry(5, 500) {
                        sendEmail(text, it)
                    }
                }
            }.awaitAll()
        }
    }
}


class CoroutinesImplementationTest {

    @Test
    fun `should test coroutines`(): Unit = runBlocking {
        val messageSender = MessageSenderCoroutines()
        messageSender.sendMessage("This is a message", (1..100).map {
            User(
                id = Random.nextLong(), name = "user-${UUID.randomUUID()}", email = "user-${UUID.randomUUID()}"
            )
        })

    }
}
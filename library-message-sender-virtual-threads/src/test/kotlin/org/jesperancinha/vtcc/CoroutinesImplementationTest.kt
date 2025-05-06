package org.jesperancinha.vtcc

import kotlinx.coroutines.*
import org.jesperancinha.vtcc.MessageSender.Companion.sendEmail
import org.jesperancinha.vtcc.messenger.User
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
    fun `should test coroutines`(): Unit = runBlocking(Dispatchers.IO) {
        val messageSender = MessageSenderCoroutines()
        runCatching {
            messageSender.sendMessage("This is a message", (1..100).map {
                User(
                    id = Random.nextLong(), name = "user-${UUID.randomUUID()}", email = "user-${UUID.randomUUID()}"
                )
            })
        }
    }
}
package org.jesperancinha.vtcc

import org.jesperancinha.vtcc.MessageSender.Companion.logger
import org.jesperancinha.vtcc.messenger.User
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.random.Random.Default.nextLong

class MessageSenderKtTest {

    @Test
    fun `should run main test`() {
        val messageSender = MessageSender()
        logger.info("Starting to send messages")
        messageSender.sendMessage("This is a message", (1..100).map {
            User(
                id = nextLong(), name = "user-${UUID.randomUUID()}", email = "user-${UUID.randomUUID()}"
            )
        })
    }
}
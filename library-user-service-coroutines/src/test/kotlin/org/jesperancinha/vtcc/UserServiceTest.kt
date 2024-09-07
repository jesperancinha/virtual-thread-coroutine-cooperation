package org.jesperancinha.vtcc

import io.kotest.matchers.collections.shouldHaveSize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class UserServiceTest {

    private val userService = UserService()

    @Test
    fun `should run main tests`(): Unit = runBlocking(Dispatchers.IO) {
        userService.loadUserData(1000)
        delay(2000)
        userService.getAllUsers().toList() shouldHaveSize  1
    }
}
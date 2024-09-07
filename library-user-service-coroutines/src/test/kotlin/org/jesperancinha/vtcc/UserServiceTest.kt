package org.jesperancinha.vtcc

import io.kotest.matchers.shouldHave
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import io.kotest.matchers.collections.shouldHaveSize
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.toList

class UserServiceTest {

    private val userService = UserService()

    @Test
    fun `should run main tests`(): Unit = runBlocking(Dispatchers.IO) {
        userService.loadUserData(1000)
        delay(2000)
        userService.getAllUsers().toList() shouldHaveSize  1
    }
}
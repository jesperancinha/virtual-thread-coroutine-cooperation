package org.jesperancinha.vtcc

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class UserServiceTest {

    @Test
    fun `should run main tests`() = runBlocking(Dispatchers.IO) {
        val userService = UserService()
        userService.loadUserData(1000)
    }
}
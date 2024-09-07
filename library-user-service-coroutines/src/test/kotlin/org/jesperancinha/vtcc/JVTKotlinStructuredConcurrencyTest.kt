package org.jesperancinha.vtcc

import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.api.Test

class JVTKotlinStructuredConcurrencyTest {
    private val userServiceJava = UserServiceVT()

    @Test
    fun testJavaConcurrency() {
        userServiceJava.loadUserData(1000)
        userServiceJava.getAllUsers() shouldHaveSize 1
    }
}
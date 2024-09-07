package org.jesperancinha.vtcc

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.should
import org.junit.jupiter.api.Test
import java.util.concurrent.ExecutionException
import java.util.concurrent.StructuredTaskScope.ShutdownOnFailure

class JVTKotlinStructuredConcurrencyTest {
    private val userServiceJava = UserServiceVT()

    @Test
    fun testJavaConcurrency() {
        userServiceJava.loadUserData(1000)
        userServiceJava.getAllUsers() shouldHaveSize 1
    }
}
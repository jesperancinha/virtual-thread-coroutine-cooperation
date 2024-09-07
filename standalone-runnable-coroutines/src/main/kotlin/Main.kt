package org.jesperancinha

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    for (i in 0 until 10) {
        launch {
            println("Coroutine $i is running.")
            delay(1000)
            println("Coroutine $i has finished.")
        }
    }
    delay(2000)
}

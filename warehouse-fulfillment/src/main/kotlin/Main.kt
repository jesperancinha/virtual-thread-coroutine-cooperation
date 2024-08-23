package org.jesperancinha

import java.util.concurrent.Executors
import java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor

object VirtualThreadsExample {
    @Throws(InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        newVirtualThreadPerTaskExecutor().use { executor ->
            for (id in 0..9) {
                executor.submit {
                    println("Virtual Thread $id is running.")
                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    println("Virtual Thread $id has finished.")
                }
            }
        }
        Thread.sleep(2000)
    }
}

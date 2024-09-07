package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WarehouseFulfilmentVirtualThreadsCoroutines

fun main(args: Array<String>) {
    SpringApplication.run(WarehouseFulfilmentVirtualThreadsCoroutines::class.java, *args)
}
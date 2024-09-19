package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WarehouseFulfilmentVirtualThreadsLauncher

fun main(args: Array<String>) {
    SpringApplication.run(WarehouseFulfilmentVirtualThreadsLauncher::class.java, *args)
}
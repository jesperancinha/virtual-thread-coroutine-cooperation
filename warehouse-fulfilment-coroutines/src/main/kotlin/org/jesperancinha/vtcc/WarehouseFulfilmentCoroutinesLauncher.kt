package org.jesperancinha.vtcc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WarehouseFulfilmentCoroutinesLauncher

fun main(args: Array<String>) {
    SpringApplication.run(WarehouseFulfilmentCoroutinesLauncher::class.java, *args)
}
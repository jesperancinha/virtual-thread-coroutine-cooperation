package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WarehouseFulfilmentWebFlux

fun main(args: Array<String>) {
    SpringApplication.run(WarehouseFulfilmentWebFlux::class.java, *args)
}
package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WarehouseFulfilmentWebFluxNonBlocking

fun main(args: Array<String>) {
    SpringApplication.run(WarehouseFulfilmentWebFluxNonBlocking::class.java, *args)
}
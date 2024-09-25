package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
class WarehouseFulfilmentMVCLauncher

fun main(args: Array<String>) {
    SpringApplication.run(WarehouseFulfilmentMVCLauncher::class.java, *args)
}
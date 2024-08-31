package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WebFluxExample

fun main(args: Array<String>) {
    SpringApplication.run(WebFluxExample::class.java, *args)
}
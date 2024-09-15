package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class VirtualThreadsErrorsExample

fun main(args: Array<String>) {
    SpringApplication.run(VirtualThreadsErrorsExample::class.java, *args)
}
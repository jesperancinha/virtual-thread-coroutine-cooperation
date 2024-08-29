package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class VirtualThreadsExample

fun main(args: Array<String>) {
    SpringApplication.run(VirtualThreadsExample::class.java, *args)
}
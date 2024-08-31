package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class VirtualThreadsExampleOld

fun main(args: Array<String>) {
    SpringApplication.run(VirtualThreadsExampleOld::class.java, *args)
}
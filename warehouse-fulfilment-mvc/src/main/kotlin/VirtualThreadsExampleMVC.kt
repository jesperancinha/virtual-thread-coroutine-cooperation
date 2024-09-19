package org.jesperancinha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class VirtualThreadsExampleMVC

fun main(args: Array<String>) {
    SpringApplication.run(VirtualThreadsExampleMVC::class.java, *args)
}
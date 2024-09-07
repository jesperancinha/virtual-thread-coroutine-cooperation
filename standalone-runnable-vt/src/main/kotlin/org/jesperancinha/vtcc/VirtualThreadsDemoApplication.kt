package org.jesperancinha.vtcc

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.stereotype.Service

@Service
class TaskService {
    @Async
    fun executeTask(taskNumber: Int) {
        println("Executing task " + taskNumber + " in thread " + Thread.currentThread().name)
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println("Task $taskNumber completed.")
    }
}

@SpringBootApplication
@EnableAsync
class VirtualThreadsDemoApplication(
    val taskService: TaskService,
    @Value("\${org.jesperancinha.vtcc.tasks}") private val tasks: Int,
) : CommandLineRunner{

    override fun run(vararg args: String?) {
        for (i in 0..tasks) {
            taskService.executeTask(i)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(VirtualThreadsDemoApplication::class.java, *args)
        }
    }
}

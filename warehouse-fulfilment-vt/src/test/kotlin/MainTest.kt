import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class MainTest {
    @Test
    fun `should run 10 virtual Threads`() {
        Executors.newVirtualThreadPerTaskExecutor().use { executor ->
            for (id in 0..9) {
                executor.submit {
                    println("Virtual Thread $id is running.")
                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    println("Virtual Thread $id has finished.")
                }
            }
        }
        Thread.sleep(2000)
    }
}
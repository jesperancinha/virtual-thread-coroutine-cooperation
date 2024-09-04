package org.jesperancinha.vtcc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;

public class JavaStructuredConcurrencyTest {


    @Test
    public void testJavaConcurrency() {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var task1 = scope.fork(() -> longRunningTask("Task1"));
            var task2 = scope.fork(() -> longRunningTask("Task2"));
            scope.join();
            scope.throwIfFailed();
            System.out.println(STR."Result 1: \{task1.get()}");
            System.out.println(STR."Result 2: \{task2.get()}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String longRunningTask(String name) throws InterruptedException {
        Thread.sleep(1000);
        return name + " completed";
    }
}

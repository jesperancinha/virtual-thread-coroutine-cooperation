package org.jesperancinha.vtcc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ThreadTests {

    private static volatile boolean isThreadFinished = false;

    @Test
    public void testShouldStopThread1() {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread is running...");
                Thread.sleep(2000);
                System.out.println("Thread finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
            System.out.println("Main thread resumed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testShouldStopThread2() {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isThreadFinished = true;
            System.out.println("Thread finished.");
        });

        thread.start();

        while (!isThreadFinished) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread resumed.");
    }

    @Test
    public void testShouldStopThread3() {
        final CountDownLatch latch = new CountDownLatch(1);

        Thread thread = new Thread(() -> {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished.");
            latch.countDown();
        });

        thread.start();

        try {
            latch.await();
            System.out.println("Main thread resumed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testShouldStopThread4() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<?> future = executor.submit((Callable<Void>) () -> {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished.");
            return null;
        });

        try {
            future.get();
            System.out.println("Main thread resumed.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    @Test
    public void testShouldStopThread5() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.submit(() -> {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished.");
        });

        executor.shutdown();

        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("All tasks completed. Main thread resumed.");
            } else {
                System.out.println("Timeout elapsed before termination.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

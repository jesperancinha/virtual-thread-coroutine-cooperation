package org.jesperancinha.vtcc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static java.util.Arrays.stream;
import static org.jesperancinha.vtcc.ForkJoinTests.SumWithForkJoin.main;

public class ForkJoinTests {

    public class SumWithForkJoin {
        private static final int THRESHOLD = 100;  // Small enough to sum directly

        public static void main(String[] args) {
            int[] array = new int[1000];
            for (int i = 0; i < array.length; i++) {
                array[i] = i + 1;
            }

            ForkJoinPool forkJoinPool = new ForkJoinPool();
            int total = forkJoinPool.invoke(new SumTask(array, 0, array.length));

            System.out.println("Total sum using ForkJoinPool: " + total);
            System.out.println("Total sum using direct calculation: " + stream(array).sum());
        }

        static class SumTask extends RecursiveTask<Integer> {
            private final int[] array;
            private final int start;
            private final int end;

            SumTask(int[] array, int start, int end) {
                this.array = array;
                this.start = start;
                this.end = end;
            }

            @Override
            protected Integer compute() {
                int length = end - start;
                if (length <= THRESHOLD) {
                    int sum = 0;
                    for (int i = start; i < end; i++) {
                        sum += array[i];
                    }
                    return sum;
                } else {
                    int middle = start + length / 2;
                    SumTask leftTask = new SumTask(array, start, middle);
                    SumTask rightTask = new SumTask(array, middle, end);
                    leftTask.fork();
                    int rightResult = rightTask.compute();
                    int leftResult = leftTask.join();
                    return leftResult + rightResult;
                }
            }
        }
    }

    @Test
    public void testShouldRunForJoins() {
        main(new String[0]);
    }

}

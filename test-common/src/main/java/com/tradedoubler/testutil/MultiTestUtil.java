package com.tradedoubler.testutil;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author bjorn
 * @since 2012-06-18
 */
public class MultiTestUtil {
    private int threads = 1;
    private int executions = 1;

    public static MultiTestUtil create() {
        return new MultiTestUtil();
    }

    private MultiTestUtil() {
    }

    public MultiTestUtil threads(int threads) {
        this.threads = threads;
        return this;
    }

    public MultiTestUtil executions(int executions) {
        this.executions = executions;
        return this;
    }

    public void test(final Callable<Void> callable) {
        Callable<Void> loopedTask = createLoopedTask(callable);
        List<Callable<Void>> tasks = Collections.nCopies(threads, loopedTask);
        try {
            long time = System.currentTimeMillis();
            invokeAll(tasks);
            long timePassed = System.currentTimeMillis() - time;
            System.out.printf("Total test time : %d ms (%d ms per execution)%n", timePassed, timePassed / executions);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private Callable<Void> createLoopedTask(final Callable<Void> callable) {
        return new Callable<Void>() {
            public Void call() throws Exception {
                for (int i = 0; i < executions; i++) {
                    long id = Thread.currentThread().getId();
                    System.out.printf("Before thread %d loop %d%n", id, i);
                    long time = System.currentTimeMillis();
                    callable.call();
                    System.out.printf("After thread %d loop %d: %d ms%n", id, i, System.currentTimeMillis() - time);
                }
                return null;
            }
        };
    }

    private void invokeAll(List<Callable<Void>> tasks) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        List<Future<Void>> futures = executorService.invokeAll(tasks);
        for (Future<Void> future : futures) {
            future.get();
        }
    }

}

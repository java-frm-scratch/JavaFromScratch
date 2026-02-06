package com.java.from.scratch.javaLatestFeatures.sixth_virtual_threads_project_loom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class VirtualThreadDemo {

    static void main() {

        //beforeVirtualThread();

        //Orders run concurrently, not sequentially.
        afterVirtualThread();

    }

    /**
     * What Happens Internally (Important)
     *
     * Each order → 1 virtual thread
     *
     * When Thread.sleep() blocks:
     *
     * Virtual thread is unmounted
     *
     * OS thread is reused
     *
     * JVM manages scheduling efficiently
     *
     * ✔ No thread starvation
     * ✔ No pool sizing
     * ✔ High throughput
     */
    private static void afterVirtualThread() {
        OrderProcessor processor = new OrderProcessor();

        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 1; i <= 10; i++) {
                int id = i;
                executor.submit(() ->
                        {
                            try {
                                processor.process(new Order("ORD-" + id, 1000));
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            }
        }
    }

    private static void beforeVirtualThread() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        OrderProcessor processor = new OrderProcessor();

        for (int i = 1; i <= 10; i++) {
            int id = i;
            executor.submit(() ->
                    {
                        try {
                            processor.process(new Order("ORD-" + id, 1000));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }

        executor.shutdown();
    }

}














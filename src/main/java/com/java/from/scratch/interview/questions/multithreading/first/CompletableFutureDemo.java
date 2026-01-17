package com.java.from.scratch.interview.questions.multithreading.first;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        // STEP 1:
        // supplyAsync() starts an async task in a separate thread
        // It uses ForkJoinPool.commonPool() by default
        CompletableFuture<String> userFuture =
                CompletableFuture.supplyAsync(() -> {

                    // Simulating remote DB / User Service call
                    sleep(1000);

                    // This value will be wrapped inside CompletableFuture
                    return "User: JavaFromScratch";
                });

        // STEP 2:
        // Another independent async task
        CompletableFuture<String> productFuture =
                CompletableFuture.supplyAsync(() -> {

                    // Simulating Catalog service latency
                    sleep(1500);

                    return "Product: Java Course";
                });

        // STEP 3:
        // Payment processing async task
        CompletableFuture<String> paymentFuture =
                CompletableFuture.supplyAsync(() -> {

                    // Simulating payment gateway delay
                    sleep(2000);

                    return "Payment: SUCCESS";
                });

        // STEP 4:
        // allOf() combines multiple CompletableFutures
        // It returns a CompletableFuture<Void>
        // This future completes ONLY when ALL given futures complete
        CompletableFuture<Void> allOf =
                CompletableFuture.allOf(
                        userFuture,
                        productFuture,
                        paymentFuture
                );

        // STEP 5:
        // thenRun() executes AFTER all futures are completed
        // No input parameter because allOf() returns Void
        allOf.thenRun(() -> {

            // join() retrieves result WITHOUT checked exception
            // Safe here because we KNOW all futures are already completed
            System.out.println(userFuture.join());
            System.out.println(productFuture.join());
            System.out.println(paymentFuture.join());

        });

        // STEP 6:
        // Prevent main thread from exiting early
        // (Only needed for demo / main method)
        sleep(3000);
    }

    // Utility method to simulate delay
    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
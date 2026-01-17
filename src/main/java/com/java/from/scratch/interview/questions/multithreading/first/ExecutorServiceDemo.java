package com.java.from.scratch.interview.questions.multithreading.first;

import java.util.concurrent.*;

public class ExecutorServiceDemo {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {



        // STEP 1:
        // Create a fixed-size thread pool with 3 threads
        // This controls how many tasks can run in parallel
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);

        // STEP 2:
        // Callable represents a task that RETURNS a value
        // Unlike Runnable, Callable can throw checked exceptions
        Callable<String> userTask = () -> {

            // Simulating DB / User service delay
            Thread.sleep(1000);

            // Value returned will be available via Future.get()
            return "User: JavaFromScratch";
        };

        // STEP 3:
        // Another independent task to fetch product details
        Callable<String> productTask = () -> {

            // Simulating catalog service latency
            Thread.sleep(1500);

            return "Product: Java Course";
        };

        // STEP 4:
        // Payment processing task
        Callable<String> paymentTask = () -> {

            // Simulating payment gateway delay
            Thread.sleep(2000);

            return "Payment: SUCCESS";
        };

        // STEP 5:
        // Submit tasks to ExecutorService
        // submit() immediately returns a Future object
        // Actual execution happens in background threads
        Future<String> userFuture =
                executorService.submit(userTask);
        boolean isUserFutureCompleetd = userFuture.isDone();
        Future.State state = userFuture.state();




        Future<String> productFuture =
                executorService.submit(productTask);

        Future<String> paymentFuture =
                executorService.submit(paymentTask);

        // STEP 6:
        // Future.get() BLOCKS the current thread
        // until the result is available
        String user = userFuture.get();
        boolean isUserFutureCompleetd2 = userFuture.isDone();
        Future.State state2 = userFuture.state();
        String product = productFuture.get();
        String payment = paymentFuture.get();

        // STEP 7:
        // Printing results AFTER all tasks finish
        System.out.println(user);
        System.out.println(product);
        System.out.println(payment);

        // STEP 8:
        // Always shutdown ExecutorService
        // Otherwise JVM may not exit
        executorService.shutdown();
    }
}

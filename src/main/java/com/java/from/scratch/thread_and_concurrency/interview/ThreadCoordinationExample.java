package com.java.from.scratch.thread_and_concurrency.interview;

/**
 * Interview Example: Demonstrating Thread Coordination
 * 
 * This example shows two ways to coordinate between threads:
 * 1. Using volatile variable (for visibility)
 * 2. Using wait()/notify() (for both visibility and coordination)
 */
public class ThreadCoordinationExample {
    // Shared flag between threads
    private static volatile boolean ready = false;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Starting Thread Coordination Example ===\n");
        
        // Example 1: Using volatile
        System.out.println("Example 1: Using volatile variable");
        System.out.println("-----------------------------------");
        volatileExample();
        
        // Small delay between examples
        Thread.sleep(1000);
        
        // Reset flag for next example
        ready = false;
        
        // Example 2: Using wait/notify
        System.out.println("\nExample 2: Using wait()/notify()");
        System.out.println("---------------------------------");
        waitNotifyExample();
    }
    
    /**
     * Example 1: Using volatile variable
     * - Demonstrates visibility guarantee of volatile
     * - Writer thread sets the flag to true
     * - Reader thread waits until flag becomes true
     */
    private static void volatileExample() throws InterruptedException {
        Thread writer = new Thread(() -> {
            System.out.println("[Writer] Starting work...");
            try {
                // Simulate some work
                Thread.sleep(1000);
                System.out.println("[Writer] Finished work, setting ready to true");
                ready = true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        Thread reader = new Thread(() -> {
            System.out.println("[Reader] Waiting for ready signal...");
            // Busy-wait loop (not efficient, but demonstrates volatile)
            while (!ready) {
                // Wait for ready flag
            }
            System.out.println("[Reader] Ready signal received!");
        });
        
        reader.start();
        // Small delay to ensure reader starts waiting first
        Thread.sleep(100);
        writer.start();
        
        // Wait for both threads to finish
        writer.join();
        reader.join();
    }
    
    /**
     * Example 2: Using wait()/notify()
     * - More efficient than busy-waiting
     * - Better for thread coordination
     */
    private static void waitNotifyExample() throws InterruptedException {
        Thread producer = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("[Producer] Starting work...");
                    Thread.sleep(1000); // Simulate work
                    System.out.println("[Producer] Work done, notifying consumer");
                    ready = true;
                    lock.notify(); // Notify waiting thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("[Consumer] Waiting for data...");
                while (!ready) {
                    try {
                        // Release lock and wait for notification
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println("[Consumer] Received data and processing...");
            }
        });

        
        consumer.start();
        // Small delay to ensure consumer starts waiting first
        Thread.sleep(100);
        producer.start();
        
        // Wait for both threads to finish
        producer.join();
        consumer.join();
        
        System.out.println("\n=== Example Completed Successfully ===");
    }
}

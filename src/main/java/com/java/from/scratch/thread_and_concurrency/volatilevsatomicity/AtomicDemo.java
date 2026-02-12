package com.java.from.scratch.thread_and_concurrency.volatilevsatomicity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Two threads modify count at the same time
 * expected output is 2000
 * but actual is different at every run ...
 * Same example WITH AtomicInteger (solution)
 *  static AtomicInteger count = new AtomicInteger(0);
 *
 *  Atomic uses CPU-level instructions like:
 *
 * CAS (Compare-And-Swap)
 *
 * Simple idea:
 *
 * “Update value ONLY if no one changed it since I last checked”
 */
public class AtomicDemo {

    static void main() throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                Counter.count++;
                //Counter.count.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();


        System.out.println(Counter.count);
    }
}

class Counter {
    static int count = 0;
    //static AtomicInteger count = new AtomicInteger(0);
}

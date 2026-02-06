package com.java.from.scratch.javaLatestFeatures.sixth_virtual_threads_project_loom;

import static java.lang.Thread.sleep;

public class OrderRepository {
    void save(Order order) throws InterruptedException {
        sleep(500); // simulate DB call
        System.out.println("Order saved: " + order.orderId());
    }
}

package com.java.from.scratch.javaLatestFeatures.sixth_virtual_threads_project_loom;

import static java.lang.Thread.sleep;

public class PaymentService {
    void pay(Order order) throws InterruptedException {
        sleep(1000); // simulate network call
        System.out.println("Payment completed for " + order.orderId());
    }
}
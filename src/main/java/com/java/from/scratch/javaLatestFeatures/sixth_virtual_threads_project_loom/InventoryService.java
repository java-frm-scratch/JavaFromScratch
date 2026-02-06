package com.java.from.scratch.javaLatestFeatures.sixth_virtual_threads_project_loom;

import static java.lang.Thread.sleep;

public class InventoryService {
    void reserve(Order order) throws InterruptedException {
        sleep(800); // simulate remote service
        System.out.println("Inventory reserved for " + order.orderId());
    }
}

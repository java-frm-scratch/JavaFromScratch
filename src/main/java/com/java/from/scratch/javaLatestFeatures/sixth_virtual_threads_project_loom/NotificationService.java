package com.java.from.scratch.javaLatestFeatures.sixth_virtual_threads_project_loom;

import static java.lang.Thread.sleep;

public class NotificationService {
    void notifyUser(Order order) throws InterruptedException {
        sleep(300); // simulate email/SMS
        System.out.println("Notification sent for " + order.orderId());
    }
}
